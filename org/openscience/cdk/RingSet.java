/* RingSet.java
 * 
 * $RCSfile$    $Author$    $Date$    $Revision$
 * 
 * Copyright (C) 1997-2000  The CompChem project
 * 
 * Contact: steinbeck@ice.mpg.de, geelter@maul.chem.nd.edu, egonw@sci.kun.nl
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License
 * as published by the Free Software Foundation; either version 2.1
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA. 
 */

package org.openscience.cdk;

import java.util.Vector;


/**
 *  Implementation of a set of Rings.
 *  Maintains a Vector "rings" to store "ring" objects
 */
public class RingSet extends Vector{
	

	/**
	 * The constructor.
	 *
	 */
	public RingSet()
	{
		super();
	}

	/**
	 * Checks - and returns 'true' - if a certain ring is already
	 * stored in this setOfRings
	 *
	 * @param   newRing  The ring to be tested if it is already stored here
	 * @return     true if it is already stored
	 */
	public boolean ringAlreadyInSet(Ring newRing)
	{
		Ring ring;
		Bond[] bonds;
		int equalCount = 0;
		for (int f = 0; f < this.size(); f++)
		{
			ring = (Ring)this.elementAt(f);
			bonds = ring.getBonds();
			if (bonds.length == newRing.getBonds().length)
			{
				for (int i = 0; i < bonds.length; i++)
				{
					for (int n = 0; n < bonds.length; n++)
					{
						if (bonds[i].equals(newRing.getBond(n)))
						{
							equalCount++;
							break;
						}
					}
				}
				if (equalCount == bonds.length)
				{
					return true;
				}
			}
		}
		return false;	
	}
}