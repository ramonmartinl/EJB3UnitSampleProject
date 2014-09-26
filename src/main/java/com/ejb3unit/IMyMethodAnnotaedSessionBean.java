package com.ejb3unit;

import java.io.Serializable;

import javax.ejb.Remote;

/**
 * Local Interface.
 * 
 * @author Daniel Wiese
 */
@Remote
public interface IMyMethodAnnotaedSessionBean extends Serializable {

	/**
	 * Op.
	 */
	public void executeOperation();

}
