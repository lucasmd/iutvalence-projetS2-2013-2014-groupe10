
public class Case
{
	private boolean casePleine;
	
	
	public Case()
	{
		this.casePleine = false;
	}

	 public boolean obtenirContenu()
	 {
		 if (this.casePleine==false)
			 return true;
		 else
			 return false;
						
	 }
}
