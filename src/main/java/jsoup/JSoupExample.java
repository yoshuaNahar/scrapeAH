package jsoup;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

final class JSoupExample {

	public static void main(String[] args) {
		JSoupExample ex = new JSoupExample();
		ex.openGoogle();
		ex.insertSearch();
	}

	private Document doc;

	private void openGoogle() {
		try {
			doc = Jsoup.connect("https://google.com/").get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String title = doc.title();
		System.out.println(title);
	}

	private void insertSearch() {
		try {
			doc = Jsoup.connect("https://google.nl/#q=Cheese!").userAgent("Chrome").get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String title = doc.title();
		System.out.println(title);
		Elements els = doc.select("a");
		Element el = null;
		for (int i = 0; true; i++) {
			el = els.get(i);
			if (el == null) {
				break;
			}
			System.out.println(el.text());
			System.out.println(el.attr("href"));
		}
	}
}
