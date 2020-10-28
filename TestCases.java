import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.*;

import org.junit.Test;
import org.junit.Before;

public class TestCases
{
   private static final Song[] songs = new Song[] {
         new Song("Decemberists", "The Mariner's Revenge Song", 2005),
         new Song("Rogue Wave", "Love's Lost Guarantee", 2005),
         new Song("Avett Brothers", "Talk on Indolence", 2006),
         new Song("Gerry Rafferty", "Baker Street", 1998),
         new Song("City and Colour", "Sleeping Sickness", 2007),
         new Song("Foo Fighters", "Baker Street", 1997),
         new Song("Queen", "Bohemian Rhapsody", 1975),
         new Song("Gerry Rafferty", "Baker Street", 1978)
      };

   @Test
   public void testArtistComparator()
   {
   }

   @Test
   public void testLambdaTitleComparator() {

      Comparator<Song> songTitle = (Song sg1, Song sg2) -> (sg1.getTitle().compareTo(sg2.getTitle()));

      //Compares songs titles
      boolean firstCompare = songTitle.compare(songs[0],songs[1]) > 0;
      boolean secondCompare = songTitle.compare(songs[3],songs[4]) < 0;

      assertEquals(true, firstCompare);
      assertEquals(true, secondCompare);

      System.out.println(songTitle);
//      Comparator.comparing()
//      Collections.sort();
//      Comparator<Song, String> songs[0] - songs[1] -> (songs[0] > songs[1]) ? -1 :
//           (songs[0] < songs[1]) ? 1 : 0);
   }

   @Test
   public void testYearExtractorComparator()
   {
   }

   @Test
   public void testComposedComparator()
   {
   }

   @Test
   public void testThenComparing()
   {

      Comparator<Song> songLst = Comparator.comparing(Song::getTitle).thenComparing(Song::getArtist);

      //Compares Song Artists
      boolean firstCompare = songLst.compare(songs[3],songs[5]) > 0;
      boolean secondCompare = songLst.compare(songs[4],songs[5]) > 0;
      assertEquals(true, firstCompare);
      assertEquals(true, secondCompare);
   }

   @Test
   public void runSort()
   {

      Comparator<Song> listCompare = Comparator.comparing(Song::getArtist).thenComparing(Song::getTitle).thenComparing(Song::getYear);
      List<Song> songList = new ArrayList<>(Arrays.asList(songs));
      List<Song> expectedList = Arrays.asList(
         new Song("Avett Brothers", "Talk on Indolence", 2006),
         new Song("City and Colour", "Sleeping Sickness", 2007),
         new Song("Decemberists", "The Mariner's Revenge Song", 2005),
         new Song("Foo Fighters", "Baker Street", 1997),
         new Song("Gerry Rafferty", "Baker Street", 1978),
         new Song("Gerry Rafferty", "Baker Street", 1998),
         new Song("Queen", "Bohemian Rhapsody", 1975),
         new Song("Rogue Wave", "Love's Lost Guarantee", 2005)
         );

      songList.sort(listCompare);
         // pass comparator here

      assertEquals(songList, expectedList);
   }
}
