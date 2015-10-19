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
package org.wicketTutorial.customconverter;

import java.util.regex.Pattern;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;
	private Pattern regExpPatter;
	private String stringToSplit;
	
    public HomePage(final PageParameters parameters) {		
    	TextField mail;
		TextField stringToSplitTxt;
		
    	Form form = new Form("form"){
			@Override
			protected void onSubmit() {
				super.onSubmit();
				String messageResult = "Tokens for the given string and pattern:<br/>";
				String[] tokens = regExpPatter.split(stringToSplit);
				
				
				for (String token : tokens) {
					messageResult += "- " + token + "<br/>";
				}
				
				success(messageResult);
			}
		};
    	
		form.setDefaultModel(new CompoundPropertyModel(this));
		form.add(mail = new TextField("regExpPatter"));
		form.add(stringToSplitTxt = new TextField("stringToSplit"));
		add(new FeedbackPanel("feedbackMessage").setEscapeModelStrings(false));
		
		add(form);
    }
     
}
