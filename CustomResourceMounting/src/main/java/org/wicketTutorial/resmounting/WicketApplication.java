/**
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.wicketTutorial.resmounting;

import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.resource.IResource;
import org.apache.wicket.request.resource.ResourceReference;

/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 * 
 * @see org.wicketTutorial.resmounting.Start#main(String[])
 */
public class WicketApplication extends WebApplication
{    	
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<HomePage> getHomePage()
	{
		return HomePage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init()
	{
		super.init();
		ResourceReference resourceReference = new ResourceReference("rssProducer"){
			RSSProducerResource deviceMetaResource = new RSSProducerResource();
			@Override
			public IResource getResource() {
				return deviceMetaResource;
			}};
			
		mountResource("/foo/bar", resourceReference);
		mountResource("/bar/${baz}", resourceReference);
		getSharedResources().add("globalRSSProducer", resourceReference.getResource());
		
	}
}
