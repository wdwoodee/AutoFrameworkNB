package com.auto.test.UIutil;



//�����Ĵ����߼��Ǻ�Excel����Ӧ�ģ����Ҫ���Excelֻ��Ҫ������࣬����������һ����Excel��Ӧ����
public class StartEngine_Excel {
	
	public static String Keywords=null;
	public static String r;
	public static boolean bResult;
	public static boolean flag;
	
	public static void StartEngine(Object actionKeyWords) throws Exception{
		
		
		/*LOGINKEYWORDS ACTIONKEYWORDS=NEW LOGINKEYWORDS();*/
		ExcelUtils.setExcelFile(Contants.excelFile+Contants.excelName );
		bResult = true;
		
//		Ñ­ï¿½ï¿½ï¿½ï¿½È¡suitSheetï¿½ï¿½ï¿½ï¿½ï¿½Öµï¿½ï¿½ï¿½Ò³ï¿½ï¿½ï¿½ï¿½ÐµÄ³ï¿½ï¿½ï¿½
		for(int j=1;j<=ExcelUtils.getLastRowNums(Contants.suitSheet);j++){
			
			String Runmode=ExcelUtils.getCellDate(j, Contants.suitRunmode,Contants.suitSheet);
			String suitTestSuiteId=ExcelUtils.getCellDate(j, Contants.suitTestSuiteId,Contants.suitSheet);
			int sRowNum;
			
			if(Runmode.equals("YES")){
//				ï¿½ï¿½ï¿½stepTestSuiteIdï¿½ï¿½caseSheetï¿½ï¿½Ñ­ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Ó¦ï¿½ï¿½Ö´ï¿½Ð²ï¿½ï¿½ï¿½
				for(sRowNum=1;sRowNum<=ExcelUtils.getLastRowNums(Contants.caseSheet);sRowNum++){
					String stepTestSuiteId=ExcelUtils.getCellDate(sRowNum, Contants.stepTestSuiteId,Contants.caseSheet);
					System.out.println(ExcelUtils.getCellDate(sRowNum, Contants.excelKWCloNum,Contants.caseSheet));
					if(stepTestSuiteId.trim().equals(suitTestSuiteId)){				
						Keywords=ExcelUtils.getCellDate(sRowNum, Contants.excelKWCloNum,Contants.caseSheet);
						r=ExcelUtils.getCellDate(sRowNum, Contants.excelPOCloNum,Contants.caseSheet);
						Common_Engine.Action(Keywords,actionKeyWords, r, sRowNum, bResult);
						if(bResult == false){
							ExcelUtils.setCellData(Contants.fail, j, Contants.caseResult,Contants.excelFile+Contants.excelName, Contants.caseSheet);
							ExcelUtils.setCellData(Contants.fail, j, Contants.suitResult,Contants.excelFile+Contants.excelName, Contants.suitSheet);
							
						}
					}	
				}
				if(bResult == true){
					ExcelUtils.setCellData(Contants.pass, j, Contants.suitResult,Contants.excelFile+Contants.excelName, Contants.suitSheet);
				}
																						
			}else{
				
				System.out.println("all testcase is done!");
				break;
			}
			
		}
		
						
	}
}
