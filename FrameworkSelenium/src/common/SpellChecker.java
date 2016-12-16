package common;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.languagetool.JLanguageTool;
import org.languagetool.language.AmericanEnglish;
import org.languagetool.language.PortugueseBrazil;
import org.languagetool.rules.RuleMatch;
import org.openqa.selenium.WebDriver;

public class SpellChecker {

	public static String[] RemoveDuplicatesWords(String text) {
		String[] words = text.split("\\s");
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words.length; j++) {
				if (words[i].equals(words[j])) {
					if (i != j) {
						words[i] = "";
					}
				}
			}
		}
		return words;
	}

	public static void ValidateWords(String sentence) throws IOException {
		JLanguageTool langToolBrazilian = new JLanguageTool(new PortugueseBrazil());
		JLanguageTool langToolEnglish = new JLanguageTool(new AmericanEnglish());
		String incorrectWords = "";
		String incorrectWordsE = "";

		List<RuleMatch> matchesBrazilian = langToolBrazilian.check(sentence);
		for (RuleMatch matchB : matchesBrazilian) {
			incorrectWords = incorrectWords + (sentence.substring(matchB.getFromPos(), matchB.getToPos()) + " ");
		}

		List<RuleMatch> matchesEnglish = langToolEnglish.check(incorrectWords);
		for (RuleMatch matchE : matchesEnglish) {
			incorrectWordsE = incorrectWordsE + " "
					+ (incorrectWords.substring(matchE.getFromPos(), matchE.getToPos()));

			if (incorrectWordsE.substring(0, 1).equals(" ")) {
				incorrectWordsE = incorrectWordsE.substring(1, incorrectWordsE.length());
			}

			if (incorrectWordsE.substring(incorrectWordsE.length() - 1, incorrectWordsE.length()).equals(" ")) {
				incorrectWordsE = incorrectWordsE.substring(0, incorrectWordsE.length() - 1);
			}
		}

		if (RemoveDuplicatesWords(incorrectWordsE).length > 0) {		
			String newSentence = "";
			for (int i = 0; i < RemoveDuplicatesWords(incorrectWordsE).length; i++) {
				if (RemoveDuplicatesWords(incorrectWordsE)[i] != "") {
					newSentence = newSentence + (RemoveDuplicatesWords(incorrectWordsE)[i] + ", ");
				}				
			}
			newSentence = newSentence.substring(0, newSentence.length()-2);
			LogRegister.info("Atenção: Possíveis erros de ortografia nas palavras: " + newSentence);
		}
	}
	
	public static void ValidateWte(WebDriver driver) throws IOException {
//		URL url = new URL(driver.getCurrentUrl());
//		HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
//		String line = null;
//		StringBuilder tmp = new StringBuilder();
//		BufferedReader in = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
//		while ((line = in.readLine()) != null) {
//		  tmp.append(line);
//		}
		 
		//Document doc = Jsoup.parse(tmp.toString());
		Document doc = Jsoup.connect("http://www.ib.bradesco.des.scopus.com.br/ibpftelainicial/home.jsf").get();
		
		
		// get the page title
		  String title = doc.title();
		  System.out.println("title: " + title);
		  
		  // get all links in page
		  Elements links = doc.select("a[href]");
		  for (Element link : links) {
		    // get the value from the href attribute
		    System.out.println("\nlink: " + link.attr("href"));
		    System.out.println("text: " + link.text());
		  }
	}
}