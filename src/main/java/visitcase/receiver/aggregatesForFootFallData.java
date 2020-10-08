package visitcase.receiver;

public class aggregatesForFootFallData
{
private IAggregatesForFootFallData llm;
public void setFileType(IAggregatesForFootFallData llm)
{
		this.llm=llm;
}
public String getAverageFootFallPerHourInAMonth(String s)
{
	return llm.getAverageFootFallPerHourInAMonth(s);
}
public String avghours(String s)
{
	return llm.avghours(s);
}
public String peakhourly(String s)
{
	return llm.peakdailyfootfalls(s);
}
}
