package com.sjhy.platform.client.deploy.srp;

import java.io.IOException;

/**
 * Exception thrown when authentication fails
 * <p>
 * Released into the public domain
 *
 * @author Jordan Zimmerman - jordan@srp.com
 * @see SRPFactory Full Documentation
 * @version 1.1
 */
public class SRPAuthenticationFailedException extends IOException
{
	public SRPAuthenticationFailedException()
	{
		super();
	}

	public SRPAuthenticationFailedException(String message)
	{
		super(message);
	}
}
