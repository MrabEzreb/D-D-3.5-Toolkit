/*
 * $RCSfile: IntegerFreeList.java,v $
 *
 * Copyright 2001-2008 Sun Microsystems, Inc.  All Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Sun designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Sun in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Sun Microsystems, Inc., 4150 Network Circle, Santa Clara,
 * CA 95054 USA or visit www.sun.com if you need additional information or
 * have any questions.
 *
 * $Revision: 1.5 $
 * $Date: 2008/02/28 20:17:25 $
 * $State: Exp $
 */

package javax.media.j3d;

class IntegerFreeList extends MemoryFreeList {

    int count = 0;

    // default the initial count to 1
    IntegerFreeList() {
	super("java.lang.Integer");
    }

    // sets up an initial count and an initial capacity for the freelist
    IntegerFreeList(int initialCount, int initCapacity) {
	super("java.lang.Integer", initCapacity);
	count = initialCount;
    }

    synchronized Object getObject() {
	if (size > 0) return super.removeLastElement();
	else return new Integer(++count);
    }

    public synchronized void clear() {
	super.clear();
	count = 0;
    }
    
}
