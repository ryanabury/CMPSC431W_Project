package com.fusion.html;

import com.fusion.objects.SaleItem;
import com.fusion.objects.User;

import static j2html.TagCreator.*;

import j2html.tags.ContainerTag;

public class ItemSearchPage extends AbstractPage {

	private String[] searchParameters;
	private SaleItem[] searchResults;

	public ItemSearchPage(User user, String[] searchParameters, SaleItem[] searchResults) {
		super(user);
		if (searchParameters == null) {
			this.searchParameters = new String[0];
		} else {
			this.searchParameters = searchParameters;
		}
		if (searchResults == null) {
			this.searchResults = new SaleItem[0];
		} else {
			this.searchResults = searchResults;
		}
	}

	@Override
	protected ContainerTag generateBody() {
		return div().with(generateSearchBar(), generateSearchResults());
	}
	
	private ContainerTag generateSearchBar() {
		return form().withMethod("GET").withAction("itemsearch.jsp").with(
				input()
						.withType("text")
						.withName(PostParameters.SEARCH_TERMS),
				input()
						.withType("submit")
						.withValue("Search")
		);
	}
	
	private ContainerTag generateSearchResults() {
		if (searchResults.length == 0) {
			return new ContainerTag("p");
		} else {
			ContainerTag div = div();
			for (int i = 0; i < searchResults.length; i++) {
				SaleItem searchResult = searchResults[i];
				div.with(
						div().with(
								a().with(
										h3(searchResult.getName())
								).withHref("/item?id=" + searchResult.getId()),
								p(searchResult.getDescription())
						)
				);
			}
			return div;
		}
	}

	@Override
	protected String pageTitle() {
		return "Search for Item";
	}

}
