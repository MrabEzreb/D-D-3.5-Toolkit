/*
 * $RCSfile: LwLightObject.java,v $
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
 * $Date: 2007/02/09 17:20:07 $
 * $State: Exp $
 */

package com.sun.j3d.loaders.lw3d;



import javax.vecmath.Color3f;
import javax.media.j3d.Light;


/**
 * This class is used to set the Light Intensity value according to the
 * keyframe value of the envelope for that light. The class is used in
 * conjunction with LightIntensityPathInterpolator, which uses this
 * class as the target of its interpolations.
 */

class LwLightObject {

    float intensity;
    Color3f color;
    Light theLight;
    
    LwLightObject(Light theLight, float intensity, Color3f color) {
	this.intensity = intensity;
	this.color = color;
	this.theLight = theLight;
    }

    void setIntensity(float intensity) {
	Color3f newLightColor = new Color3f(color.x * intensity,
					    color.y * intensity,
					    color.z * intensity);
	if (theLight != null)
	    theLight.setColor(newLightColor);
	this.intensity = intensity;
    }

    void setColor(Color3f color) {
	Color3f newLightColor = new Color3f(color.x * intensity,
					    color.y * intensity,
					    color.z * intensity);
	if (theLight != null)
	    theLight.setColor(newLightColor);
	this.color = color;
    }

    void setLight(Light l) {
	theLight = l;
	Color3f newLightColor = new Color3f(color.x * intensity,
					    color.y * intensity,
					    color.z * intensity);
	if (theLight != null)
	    theLight.setColor(newLightColor);
    }
}
    
    