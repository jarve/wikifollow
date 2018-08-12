/**
 * 
 */
package wikifollow;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author pj
 *
 */
public class Wikifollow {

	static final String ENTITY ="http://www.wikidata.org/entity/";
	static final String TAB = "\t";
	static final String LM = "\"";
	static String[] tulos = new String[150];
	static int lkm = 1;

	/**
	 * @param args String Tiedsoton nimi
	 */
	public static void main(String[] args) {
		try (Stream<String> stream = Files.lines(Paths.get(args[0]))) {
			stream.filter(l -> l.startsWith(ENTITY)).forEach(l -> process(l));
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(int i = 1 ; i < lkm; i++) {
			System.out.println(tulos[i]+TAB+"P156"+TAB+tulos[i+1]);
			System.out.println(tulos[i+1]+TAB+"P155"+TAB+tulos[i]);
			System.out.println(tulos[i]+TAB+"Lfi"+TAB+LM+"Matteus "+i+LM);
			System.out.println(tulos[i]+TAB+"Dfi"+TAB+LM+"Evankeliumi Matteuksen mukaan, "+i+". luku"+LM);
			System.out.println(tulos[i]+TAB+"Afi"+TAB+LM+"Matt. "+i+LM);
			System.out.println(tulos[i]+TAB+"Afi"+TAB+LM+"Matteuksen evankeliumin "+i+". luku"+LM);
		}

	}

	static void process(String l) {
		String[] sa = l.split("\t");
		String[] sa1 = sa[1].split(" ");
		tulos[Integer.parseInt(sa1[1])] = sa[0].substring(ENTITY.length());
		lkm++;
	}
}
