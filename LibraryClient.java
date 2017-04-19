import Library.*;

import org.omg.CosNaming.*;

import org.omg.CosNaming.NamingContextPackage.*;

import org.omg.CORBA.*;

import java.util.*;

public class LibraryClient {

public static void main(String args[]){

try{

Scanner sc=new Scanner(System.in);

int c=0,ch,ch1;

ORB orb = ORB.init(args, null);

org.omg.CORBA.Object objRef =

orb.resolve_initial_references(&quot;NameService&quot;);

NamingContext ncRef = NamingContextHelper.narrow(objRef);

NameComponent nc = new NameComponent (&quot;Adder&quot;, &quot;&quot;);

NameComponent path[] = {nc};

Lib Ref = LibHelper.narrow(ncRef.resolve(path));

while(c!=1){

System.out.println(&quot;What Do You Want To Do 1.Issue 2.Return

3.Exit&quot;);

ch=sc.nextInt();

if(ch==1){

System.out.println(&quot;Which book to issue 1.DMBI 2.DS

3.SWS 4.SE&quot;);

ch1=sc.nextInt();

int o=Ref.issue(ch1);

if(o==0){

System.out.println(&quot;No issue&quot;);

}

else System.out.println(&quot;Issued&quot;);

}

else if(ch==2){

System.out.println(&quot;Which book to retrun 1.DMBI 2.DS

3.SWS 4.SE&quot;);

ch1=sc.nextInt();

int o=Ref.return1(ch1);

if(o==0){

System.out.println(&quot;Error&quot;);

}

else System.out.println(&quot;Returned&quot;);

}

else {

c=1;

}

}

}
catch(Exception e) {System.out.println(e);}

}

}

