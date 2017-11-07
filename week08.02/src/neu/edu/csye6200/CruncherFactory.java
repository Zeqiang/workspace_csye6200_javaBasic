package neu.edu.csye6200;

import java.util.List;

import neu.edu.csye6200.API.CruncherReceiverAPI;

public class CruncherFactory {

	public CruncherFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public CruncherReceiverAPI getNumberCruncher(List<String> criteria){
		String mainCriteria = null;
		String subCriteria = null;
		
		if (criteria == null || criteria.size() < 2) {
			System.err.println(this.getClass().getSimpleName()
					+ ": ERROR:  Invalid criteria"
					+ " [" + criteria.size() +"]"
					+ " '" + criteria.get(0) + "'"
					+ " '" + criteria.get(1) + "'"
					);
			return null;
		}
		mainCriteria = criteria.get(0);
		subCriteria = criteria.get(1);
		if (mainCriteria.equalsIgnoreCase("INTEGER")) {
			if (subCriteria.equalsIgnoreCase("AVG")) {
				return new IntegerAvg();
			} else if (subCriteria.equalsIgnoreCase("RANK")) {
				return new IntegerRank();
			} else if (subCriteria.equalsIgnoreCase("SUM")) {
				return new IntegerSum();
			}
		}
		return null;
	}

}
