/*
 * $RCSfile: TexCoordGenerationState.java,v $
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
 * $Date: 2007/02/09 17:20:39 $
 * $State: Exp $
 */

package com.sun.j3d.utils.scenegraph.io.state.javax.media.j3d;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import com.sun.j3d.utils.scenegraph.io.retained.Controller;
import com.sun.j3d.utils.scenegraph.io.retained.SymbolTableData;
import javax.media.j3d.SceneGraphObject;
import javax.media.j3d.TexCoordGeneration;
import javax.vecmath.Vector4f;

public class TexCoordGenerationState extends NodeComponentState {
    
    public TexCoordGenerationState( SymbolTableData symbol, Controller control ) {
        super(symbol, control);
    }
    
    public void writeObject( DataOutput out ) throws IOException {
        super.writeObject( out );
        TexCoordGeneration attr = (TexCoordGeneration)node;
        Vector4f vec = new Vector4f();
        out.writeBoolean( attr.getEnable() );
        out.writeInt( attr.getFormat() );
        out.writeInt( attr.getGenMode() );
        attr.getPlaneR( vec );
        control.writeVector4f( out, vec );
        attr.getPlaneS( vec );
        control.writeVector4f( out, vec );
        attr.getPlaneT( vec );
        control.writeVector4f( out, vec );
        attr.getPlaneQ( vec );
        control.writeVector4f( out, vec );
    }
    
    public void readObject( DataInput in ) throws IOException {
        super.readObject( in );
        TexCoordGeneration attr = (TexCoordGeneration)node;
        attr.setEnable( in.readBoolean() );
        attr.setFormat( in.readInt() );
        attr.setGenMode( in.readInt() );
        attr.setPlaneR( control.readVector4f( in ));
        attr.setPlaneS( control.readVector4f( in ));
        attr.setPlaneT( control.readVector4f( in ));
	attr.setPlaneQ( control.readVector4f( in ));
    }
    
    protected javax.media.j3d.SceneGraphObject createNode() {
        return new TexCoordGeneration();
    }

    
}

