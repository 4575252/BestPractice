package org.chapter0333;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class EnableSellerAspect {
   @DeclareParents(value="org.chapter0333.NaiveWaiter",
		   defaultImpl=SmartSeller.class)
   public  Seller seller;
}
