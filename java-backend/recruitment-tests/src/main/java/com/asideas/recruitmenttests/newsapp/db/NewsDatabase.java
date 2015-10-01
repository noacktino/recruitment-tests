package com.asideas.recruitmenttests.newsapp.db;

import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import com.asideas.recruitmenttests.newsapp.pojo.NewsPojo;

/**
 * This class implements the database access. Therefore all methods are 
 * synchronized in order avoid concurrent access.
 * 
 * @author Tino 
 *
 */
public class NewsDatabase {
	
	/**
	 * The database simulated by a map.
	 */
	private static Map<UUID, NewsPojo> database = new HashMap<UUID, NewsPojo>();
	
	// Insert initial content to the database.
	static {
		NewsPojo news1 = new NewsPojo();
		news1.setId(UUID.fromString("9650f9ec-83c1-46bf-8cdf-cfa71f6dbb7d"));
		news1.setHeader("Syria conflict: Russia launches fresh strikes");
		news1.setShortDescription("Russia has launched air strikes in Syria "
				+ "for a second day, saying that Islamic State (IS) had been "
				+ "targeted.");
		news1.setText("The defence ministry said its jets had destroyed an IS "
				+ "ammunition depot and control centres. However, the areas "
				+ "reportedly attacked appeared to be held by groups opposed "
				+ "to IS and the Syrian government. The US and its allies fear "
				+ "the strikes have been targeting non-IS opponents of "
				+ "Russia's ally, Syrian President Bashar al-Assad - a claim "
				+ "denied by Moscow. Meanwhile, the Pentagon and Russian "
				+ "military officials are due to hold talks on avoiding "
				+ "clashes between their forces in Syria. The latest attacks "
				+ "reportedly hit sites in the north-west held by the Army of "
				+ "Conquest rebel alliance, as well as areas in Homs and Hama "
				+ "provinces. The strategic town of Jisr al-Shughour was hit, "
				+ "as well as areas in Idlib province and Hama province "
				+ "further south, according to Lebanon's al-Mayadeen TV. Rebel "
				+ "activists also reported strikes at Ghantu in Homs province, "
				+ "close to some of Wednesday's attacks. Russia said it had "
				+ "hit 12 IS positions in the past 24 hours, although this "
				+ "cannot be independently verified.");
		Set<String> authors = new HashSet<String>();
		authors.add("Jonathan Marcus");
		news1.setAuthors(authors);
		news1.setPublishDate(Calendar.getInstance().getTime());
		Set<String> keyWords = new HashSet<String>();
		keyWords.add("Syria conflict");
		keyWords.add("Russia");
		keyWords.add("Middle East");
		news1.setKeywords(keyWords);
		database.put(news1.getId(), news1);

		NewsPojo news2 = new NewsPojo();
		news2.setId(UUID.fromString("071c74c2-1885-4739-8690-af9907afb977"));
		news2.setHeader("Time for German Industry to Abandon Its Arrogance");
		news2.setShortDescription("Arrogance and complacency are widespread "
				+ "in Germany industry, with Volkswagen becoming just the most "
				+ "recent example. For the German economy to remain healthy, "
				+ "fundamental changes are necessary. ");
		news2.setText("The best commentary on the Volkswagen scandal came "
				+ "courtesy of former CEO Martin Winterkorn himself, well "
				+ "before he resigned last week. \"Arrogance and complacency "
				+ "are the worst things that could happen to us,\" he said. "
				+ "The quote does not come from in his recent video message, "
				+ "where he attempted to apologize for the company's "
				+ "self-destruction. Rather, it is from an interview with "
				+ "SPIEGEL that took place exactly a year ago. And he meant it "
				+ "merely as a description of a hypothetical danger. He didn't "
				+ "yet realize that the worst had already long since happened. "
				+ "A belief in their own invincibility is widespread among "
				+ "Germany's captains of industry. When it comes to reaching "
				+ "the goals they've set for themselves, they will resort to "
				+ "any means necessary. In the case of Volkswagen, it was "
				+ "undone by its desire to outstrip Toyota as the world's "
				+ "biggest carmaker. In the case of Deutsche Bank, it was its "
				+ "all-consuming aim to achieve a 25 percent return on equity. "
				+ "The pursuit of this goal made it guilty of almost every one "
				+ "of those financial-sector transgressions that ultimately "
				+ "led to the crisis. In the aftermath, the bank sought to "
				+ "fundamentally change its company culture, a shift that "
				+ "failed badly. Today, Deutsche Bank is but a shadow of its "
				+ "former self.");
		authors = new HashSet<String>();
		authors.add("Armin Mahler");
		news2.setAuthors(authors);
		news2.setPublishDate(Calendar.getInstance().getTime());
		keyWords = new HashSet<String>();
		keyWords.add("VW Scandal");
		keyWords.add("Made in Germany");
		keyWords.add("Martin Winterkorn");
		news2.setKeywords(keyWords);
		database.put(news2.getId(), news2);
	}
	
	/**
	 * This method reads a news entry from the database.
	 * 
	 * @param news the id of the news entry 
	 * @return the requested news entry when available else null
	 */
	public synchronized static NewsPojo read(UUID news) {
		return database.get(news);
	}
	
	/**
	 * This method reads all news entries from the database.
	 * 
	 * @return a list of all available news entries
	 */
	public synchronized static List<NewsPojo> read() {
		return new LinkedList<NewsPojo>(database.values());
	}
	
	/**
	 * This method inserts a new news entry to the database. The UUID field
	 * should be empty. It's generated by the API.
	 * 
	 * @param pojo the news entry with empty UUID
	 * @return the newly generated UUID of this entry
	 */
	public synchronized static UUID insert(NewsPojo pojo) {
		pojo.setId(UUID.randomUUID());
		database.put(pojo.getId(), pojo);
		return pojo.getId();
	}
	
	/**
	 * This method removes an entry from the database.
	 * 
	 * @param id the entry which should be removed
	 * @return true if entry was deleted else false
	 */
	public synchronized static boolean delete(UUID id) {
		return database.remove(id) != null;
	}
	
	/**
	 * This method updates an existing entry in the database. Partial updates
	 * are not allowed. The POJO must be updated entirely.
	 * 
	 * @param pojo the entry containing the specific UUID
	 * @return true if entry was updated else false
	 */
	public synchronized static boolean update(NewsPojo pojo) {
		if(database.containsKey(pojo.getId())) {
			database.remove(pojo.getId());
			return database.put(pojo.getId(), pojo) != null;
		} else {
			return false;
		}
	}

}
