package com.fusion.html;

import j2html.tags.ContainerTag;
import static j2html.TagCreator.*;

public class CreateUserPage extends AbstractPage {

	public CreateUserPage(){
		super();
	}
	
	@Override
	protected ContainerTag generateBody() {
		// TODO Auto-generated method stub
		return div();
	}

	@Override
	protected String pageTitle() {
		return "Create User";
	}

}
