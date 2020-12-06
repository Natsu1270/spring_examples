package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        BizLogic bizLogic = context.getBean("bizLogic", BizLogic.class);

        boolean isBlock = true;

        System.out.println(bizLogic.getFortune(isBlock));
        context.close();
    }
}
