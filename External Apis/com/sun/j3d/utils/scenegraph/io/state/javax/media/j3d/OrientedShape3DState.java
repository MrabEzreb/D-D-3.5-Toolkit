/*
 * $RCSfile: OrientedShape3DState.java,v $
 *
 * Copyright (c) 2007 Sun Microsystems, Inc. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * - Redistribution of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 *
 * - Redistribution in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in
 *   the documentation and/or other materials provided with the
 *   distribution.
 *
 * Neither the name of Sun Microsystems, Inc. or the names of
 * contributors may be used to endorse or promote products derived
 * from this software without specific prior written permission.
 *
 * This software is provided "AS IS," without a warranty of any
 * kind. ALL EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS AND
 * WARRANTIES, INCLUDING ANY IMPLIED WARRANTY OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE OR NON-INFRINGEMENT, ARE HEREBY
 * EXCLUDED. SUN MICROSYSTEMS, INC. ("SUN") AND ITS LICENSORS SHALL
 * NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF
 * USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS
 * DERIVATIVES. IN NO EVENT WILL SUN OR ITS LICENSORS BE LIABLE FOR
 * ANY LOST REVENUE, PROFIT OR DATA, OR FOR DIRECT, INDIRECT, SPECIAL,
 * CONSEQUENTIAL, INCIDENTAL OR PUNITIVE DAMAGES, HOWEVER CAUSED AND
 * REGARDLESS OF THE THEORY OF LIABILITY, ARISING OUT OF THE USE OF OR
 * INABILITY TO USE THIS SOFTWARE, EVEN IF SUN HAS BEEN ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGES.
 *
 * You acknowledge that this software is not designed, licensed or
 * intended for use in the design, construction, operation or
 * maintenance of any nuclear facility.
 *
 * $Revision: 1.4 $
 * $Date: 2007/02/09 17:20:37 $
 * $State: Exp $
 */

package com.sun.j3d.utils.scenegraph.io.state.javax.media.j3d;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import javax.media.j3d.OrientedShape3D;
import javax.vecmath.Point3f;
import javax.vecmath.Vector3f;

import com.sun.j3d.utils.scenegraph.io.retained.Controller;
import com.sun.j3d.utils.scenegraph.io.retained.SymbolTableData;

public class OrientedShape3DState extends Shape3DState {
    
    public OrientedShape3DState(SymbolTableData symbol,Controller control) {
        super( symbol, control );
        
    }
    
    public void writeObject( DataOutput out ) throws IOException {
        super.writeObject( out );
        
        out.writeInt( ((OrientedShape3D)node).getAlignmentMode() );
        
        Vector3f vec = new Vector3f();
        ((OrientedShape3D)node).getAlignmentAxis( vec );
        
        Point3f point = new Point3f();
        ((OrientedShape3D)node).getRotationPoint( point );
        
        control.writeVector3f( out, vec );
        control.writePoint3f( out, point );
	out.writeBoolean( ((OrientedShape3D)node).getConstantScaleEnable() );
	out.writeDouble( ((OrientedShape3D)node).getScale() );
    }
    
    public void readObject( DataInput in ) throws IOException {
        super.readObject( in );
          
        ((OrientedShape3D)node).setAlignmentMode( in.readInt() );
        ((OrientedShape3D)node).setAlignmentAxis( control.readVector3f( in ) );
        ((OrientedShape3D)node).setRotationPoint( control.readPoint3f( in ) );
        ((OrientedShape3D)node).setConstantScaleEnable( in.readBoolean() );
        ((OrientedShape3D)node).setScale( in.readDouble() );
    }
    
    protected javax.media.j3d.SceneGraphObject createNode() {
        return new OrientedShape3D();
    }

        
}
