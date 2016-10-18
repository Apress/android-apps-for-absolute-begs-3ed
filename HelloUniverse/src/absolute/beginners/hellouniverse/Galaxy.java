package absolute.beginners.hellouniverse;
public class Galaxy {
	   String galaxyName;
	   int galaxySolarSystems;
	   int galaxyPlanets;
	   long galaxyColonies;
	   double galaxyLifeforms;
	   int galaxyFleets;
	   int galaxyStarships;
	   public Galaxy (String name, int solarSys, int planets) {
	      galaxyName = name;
	      galaxySolarSystems = solarSys;
	      galaxyPlanets = planets;
	      galaxyColonies = 0;
	      galaxyLifeforms = 0;
	      galaxyFleets = 0;
	      galaxyStarships = 0;
	   }
	   void setGalaxyColonies (long numberColonies) {
	      galaxyColonies += numberColonies;
	   }
	   long getGalaxyColonies() {
	      return galaxyColonies;
	   }
	   void setGalaxyPopulation (double numberLifeforms) {
	      galaxyLifeforms += numberLifeforms;
	   }
	   double getGalaxyPopulation() {
	      return galaxyLifeforms;
	   }
	   void setGalaxyFleets (int numberFleets) {
	      galaxyFleets += numberFleets;
	   }
	   int getGalaxyFleets() {
	      return galaxyFleets;
	   }
	   void setGalaxyStarships (int numberStarships) {
	      galaxyStarships += numberStarships;
	   }
	   int getGalaxyStarships() {
	      return galaxyStarships;
	   }
}
