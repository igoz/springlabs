package lab.aop;

import lab.model.Customer;
import lab.model.Squishee;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Politeness {

    @Pointcut("execution(* sellSquishee(..))")
    private void sellSquishee() {}

    @Before("sellSquishee()")
    public void sayHello(JoinPoint joinPoint) {
        AopLog.append("Hello " + ((Customer) joinPoint.getArgs()[0]).getName() + ". How are you doing? \n");
    }

    @AfterReturning(pointcut = "sellSquishee()",
        returning = "retVal")
    public void askOpinion(Squishee retVal) {
        AopLog.append("Is " + retVal.getName() + " Good Enough? \n");
    }

    @AfterThrowing("sellSquishee()")
    public void sayYouAreNotAllowed() {
        AopLog.append("Hmmm... \n");
    }

    @After("sellSquishee()")
    public void sayGoodBye() {
        AopLog.append("Good Bye! \n");
    }

    @Around("sellSquishee()")
    public Object sayPoliteWordsAndSell(ProceedingJoinPoint pjp) throws Throwable {
        AopLog.append("Hi! \n");
        Object retVal = pjp.proceed();
        AopLog.append("See you! \n");
        return retVal;
    }

}