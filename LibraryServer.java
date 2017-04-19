import Library.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
public class LibraryServer extends _LibImplBase
{
	static int[] a = {2,2,2,2};

	public int issue(int x)
	{
		int i=0;
		if(a[x-1]==0){
			i=0;
		}
		else
		{
			a[x-1]=a[x-1]-1;
			i=1;
		}
		return i;
	}	
	public int return1(int x)
	{
		int i=1;
		a[x-1]=a[x-1]+1; 
		return i;
	}
	public static void main(String args[]){
		try{
			ORB orb = ORB.init(args, null); 
			LibraryServer adderRef = new LibraryServer();
			orb.connect(adderRef);
			org.omg.CORBA.Object objRef =
			orb.resolve_initial_references("NameService");
			NamingContext ncRef = NamingContextHelper.narrow(objRef);
			NameComponent nc = new NameComponent ("Adder", "");
			NameComponent path[] = {nc};
			ncRef.rebind(path, adderRef);
			Thread.currentThread().join();
		}
		catch(Exception e)	{System.out.println(e);}
	}
}

