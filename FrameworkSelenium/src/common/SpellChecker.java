package common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Base64;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.languagetool.JLanguageTool;
import org.languagetool.language.AmericanEnglish;
import org.languagetool.language.PortugueseBrazil;
import org.languagetool.rules.RuleMatch;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pages.AccLimitsAvailableForBuyAndSake;

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
			newSentence = newSentence.substring(0, newSentence.length() - 2);
			LogRegister.info("Atenção: Possíveis erros de ortografia nas palavras: " + newSentence);
		}
	}

	public static void ValidateWte(WebDriver driver) throws IOException {
		//WebElement initialUrl = ;
		//String initialUrl = "return document.getElementById('urlInicial').value;";
		String initialUrl = "return window.location.href;";

		String valueUrl3 = ((JavascriptExecutor) driver).executeScript("return window.location.href;").toString();
		String valueUrl4 = ((JavascriptExecutor) driver).executeScript("return window.location.href;").toString();
		
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.addEventListener('load',function({document.getElementsByTagName('urlInicial')[1]})");
		String valueUrl = ((JavascriptExecutor) driver).executeScript("return window.location.href;").toString();

		
		
		
		
		
		// URL url;
		// URLConnection urlConn = null;
		// HttpURLConnection htcon = null;
		// InputStream is = null;
		// StringBuffer sb = new StringBuffer();
		// String authStr = "apikey:password";
		//
		// byte[] authStringEnc =
		// Base64.getEncoder().encode(authStr.getBytes());
		//
		// //String authStringEnc = new
		// String(Base64Encoder.encode(authString.getBytes()));
		// try {
		// url = new
		// URL("http://www.ib.bradesco.des.scopus.com.br/ibpftelainicial/home.jsf");
		// urlConn = url.openConnection();
		// urlConn.setRequestProperty("Authorization", "Basic " +
		// authStringEnc);
		// ((HttpURLConnection) urlConn).setRequestMethod("GET");
		// urlConn.setRequestProperty("user-agent","Mozilla/5.0");
		// urlConn.setRequestProperty("Content-Type","application/json");
		//
		// htcon = (HttpURLConnection) urlConn;
		// is = htcon.getInputStream();
		// InputStreamReader isr = new InputStreamReader(is);
		//
		// int numCharsRead;
		// char[] charArray = new char[1024];
		//
		// while ((numCharsRead = isr.read(charArray)) > 0) {
		// sb.append(charArray, 0, numCharsRead);
		// }
		// }
		// catch (IOException e) {
		// e.printStackTrace();
		// }
		//
		//
		//
		//
		// URLConnection urlConn = null;
		// String authStr = "apikey:password";
		// URL url = new
		// URL("http://www.ib.bradesco.des.scopus.com.br/ibpftelainicial/home.jsf");
		// urlConn = url.openConnection();
		// urlConn.setRequestProperty("Authorization", "Basic " +
		// Base64.getEncoder().encode(authStr.getBytes()));
		// urlConn.setRequestProperty("user-agent", "Mozilla/5.0");
		// urlConn.setRequestProperty("Content-Type", "application/json");
		// HttpURLConnection urlConn2 = (HttpURLConnection)
		// url.openConnection();
		// String line = null;
		// StringBuilder tmp = new StringBuilder();
		// BufferedReader in = new BufferedReader(new
		// InputStreamReader(urlConn.getInputStream()));
		// while ((line = in.readLine()) != null) {
		// tmp.append(line);
		// }

		Connection con = Jsoup.connect(AccLimitsAvailableForBuyAndSake.valueUrl)
				.userAgent(
						"Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.21 (KHTML, like Gecko) Chrome/19.0.1042.0 Safari/535.21")
				.timeout(10000);
		//Connection.Response resp = con.execute();
		Document doc = con.get();

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