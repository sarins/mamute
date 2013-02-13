package br.com.caelum.brutal.integration.pages;

import static java.util.Arrays.asList;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QuestionPage extends PageObject{

	public QuestionPage(WebDriver driver) {
		super(driver);
	}
	
	public EditQuestionPage toEditQuestionPage(){
		byClassName("edit-question").click();
		return new EditQuestionPage(driver);
	}

	public boolean hasInformation(String title, String description, String tags) {
		return hasTitle(title) && hasDescription(description) && hasTags(tags);
	}

	private boolean hasTitle(String questionTitle) {
		return questionTitle.equals(byClassName("question-title").getText());
	}
	
	private boolean hasDescription(String questionDescription) {
		return questionDescription.equals(byClassName("question-description").getText());
	}
	
	private boolean hasTags(String tags) {
		WebElement question = byClassName("question-area");
		List<String> tagNames = asList(tags.split(" "));
		List<WebElement> tagsElements = question.findElements(By.className("tag"));
		for (WebElement tagElement: tagsElements) {
			if(!tagNames.contains(tagElement.getText())) return false;
		}
		return true;
	}

	
}