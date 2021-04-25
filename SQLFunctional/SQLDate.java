package SQLFunctional;

import java.time.LocalDate;
import java.util.Random;

class DateGenerator 
{
	class RandomDate 
	{
		private final LocalDate minDate;
	    private final LocalDate maxDate;
	    private final Random random;

	    public RandomDate(LocalDate minDate, LocalDate maxDate) 
	    {
	        this.minDate = minDate;
	        this.maxDate = maxDate;
	        this.random = new Random();
	    }

	    public String generateDate() 
	    {
	        int minDay = (int) minDate.toEpochDay();
	        int maxDay = (int) maxDate.toEpochDay();
	        long randomDay = minDay + random.nextInt(maxDay - minDay);
	        
	        String s = "" + LocalDate.ofEpochDay(randomDay);
	        String split[] = s.split("-");
	        
	        String result = split[2] + "/" + split[1] + "/" + split[0];
	        return result;
	    }
	}
	
	RandomDate randomDate;
	
	public DateGenerator()
	{
		randomDate = new RandomDate(LocalDate.of(1900, 1, 1), LocalDate.of(2020, 1, 1));
	}
	
	public String generate()
	{
		return randomDate.generateDate();
	}
}


class SQLDate extends Attribute
{
	private DateGenerator toGenerate;
	
	public SQLDate(String attributeName, String attributeType, boolean isReferenceKey)
	{
		super(attributeName, attributeType, isReferenceKey);
		toGenerate = new DateGenerator();
	}

	@Override
	public String createAttribute() 
	{
		String str = attributeName;
		str = str + " DATE";
		return str;
	}
	
	@Override
	public String generateAttribute() 
	{
		String value = toGenerate.generate();
		listOfAttributes.add(value);
		return "TO_DATE('" + value + "','DD/MM/YYYY')";
	}
	
	@Override
	public String generateAttribute(String[] values) 
	{
		Random rand = new Random();
		String value = values[rand.nextInt(values.length-1)];
		listOfAttributes.add(value);
		return "TO_DATE('" + value + "','DD/MM/YYYY')";
	}
	
	@Override
	public boolean isPrimaryKey()
	{
		return false;
	}
	
}