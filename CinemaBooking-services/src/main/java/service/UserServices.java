package service;

import javax.ejb.Stateless;

/**
 * @author papo
 *
 */
@Stateless
public class UserServices {

	public String sayHello(){
		return "hello";
	}

}
