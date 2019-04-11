package com.tbitsglobal.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.drools.template.DataProvider;
import org.drools.template.DataProviderCompiler;
import org.kie.api.KieServices;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;

public class TestExample implements DataProvider{
	
	
	public TestExample(List<ServiceClass> rows) {
        this.iterator = rows.iterator();
    }
	
	public TestExample() {
		
	}
	
	public static void main(String[] args) {
		TestExample test=new TestExample();
		test.testCompiler();
	}
	
	public void testCompiler() {
		ArrayList<ServiceClass> rules = new ArrayList<ServiceClass>();
//		rules.add(createRule(17));
		
//		rules.add(createRule(18));
		TestExample tes=new TestExample(rules);
		 final DataProviderCompiler converter = new DataProviderCompiler();
	     final String drl = converter.compile( tes,
	                                              getTemplate() );
	     System.out.println(drl);
//	     KieServices kieServices = KieServices.Factory.get();
//	        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
//	        kieFileSystem.write("src/main/resources/rule.drl", drl);
//	        kieServices.newKieBuilder(kieFileSystem).buildAll();
//	        KieContainer kieContainer = kieServices.newKieContainer(kieServices.getRepository().getDefaultReleaseId());
//	        StatelessKieSession statelessKieSession = kieContainer.getKieBase().newStatelessKieSession();

//	        Result alertDecision = new Result();
//	        statelessKieSession.getGlobals().set("hi", alertDecision);
//	        TestClass t=new TestClass();
//	        t.setAge(20);
////	        t.setTest(12);
//	        statelessKieSession.execute(t);
//	        System.out.println(alertDecision.isDoResult());
	}
	
	public Result testCompiler(RequestClass r) {
		ArrayList<ServiceClass> rules = new ArrayList<ServiceClass>();
		for(ServiceClass str:r.getServiceclass()) {
			rules.add(str);
		}
		
		
//		rules.add(createRule(18));
		TestExample tes=new TestExample(rules);
		 final DataProviderCompiler converter = new DataProviderCompiler();
	     final String drl = converter.compile( tes,
	                                              getTemplate() );
	     System.out.println(drl);
	     KieServices kieServices = KieServices.Factory.get();
	        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
	        kieFileSystem.write("src/main/resources/rule.drl", drl);
	        kieServices.newKieBuilder(kieFileSystem).buildAll();
	        KieContainer kieContainer = kieServices.newKieContainer(kieServices.getRepository().getDefaultReleaseId());
	        StatelessKieSession statelessKieSession = kieContainer.getKieBase().newStatelessKieSession();

	        Result alertDecision = new Result();
	        statelessKieSession.getGlobals().set("hi", alertDecision);
	        statelessKieSession.execute(r.getPojo());
	        System.out.println(alertDecision.isDoResult());
	        return alertDecision;
	}
	
	

	private InputStream getTemplate() {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream( "hi.drt" );
    }
//	private ServiceClass createRule(int i) {
//		TestClass tes= new TestClass();
////		tes.setAge(i);
//		tes.setStr("age > 17");
////		tes.setTest(i);
//		return tes;
//	}

	private Iterator<ServiceClass> iterator;

	public boolean hasNext() {
		  return iterator.hasNext();
	}

	public String[] next() {
		ServiceClass nextRule = iterator.next();
		String[] row = new String[]{String.valueOf( nextRule.getCondition()),String.valueOf( nextRule.getAction())};
		return row;
	}

}

