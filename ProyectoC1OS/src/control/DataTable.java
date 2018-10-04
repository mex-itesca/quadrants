package control;

import java.util.Calendar;

public class DataTable {
    public DataTable(){ }
    
    private Calendar generateHIP(Calendar t, int s){
        time = t;
        time.add(Calendar.SECOND, s);
        return time;
    }
    
    private String generateID(){
        String format = "" + (id+=1);
        
        switch(format.length()){
            case 1: return "1"+id+"0";
            case 2: return "0"+id;
            case 3: return ""+id;
            default: 
                id = 1;
                return "00"+id;
        }
    }
    
    private String generateTTP(){
        return "" + ((int)(Math.random()*(120-60)+60));
    }
    
    private String getQuantum(){
        return "5";
    }
    
    private String generatePRI(){
        return "" + ((int)(Math.random()*11));
    }
    
    private String generateStatus(){
        int status = (int)(Math.random()*2);
        
        switch(status){
            case 0: return "Ejecucion";
            default: return "Bloqueado";
        }
    }
    
    private String generateSUCS(){
        do{
            int suc = ((int)(Math.random()*(60-20)+20));
            if(suc%10 == 0) return ""+suc;
        }while(true);
    }
    
    private Calendar generateHISUC1(Calendar hip){
        int s = (int)(Math.random()*(60-30)+30);
        hip.add(Calendar.SECOND,s);
        
        return hip;
    }
    
    private String generateTTSUCS(){
        int s = (int)(Math.random()*(40-20)+20);
        return s + "";
    }
    
    private Calendar generateHISUC2(Calendar hisuc1, int ttsuc1){
        int s = (int)(Math.random()*(60-30)+30);
        hisuc1.add(Calendar.SECOND,s);
        hisuc1.add(Calendar.SECOND,ttsuc1);
        
        return hisuc1;
    }
    
    private Calendar generateHIBS(Calendar hisuc2, int ttsuc2){
        int s = (int)(Math.random()*(60-30)+30);
        hisuc2.add(Calendar.SECOND,s);
        hisuc2.add(Calendar.SECOND,ttsuc2);
        
        return hisuc2;
    }
    
    private String generateTTBS(){
        return "" + ((int)(Math.random()*(40-20)+20));
    }
    
    private Calendar generateHILS(Calendar hibs, int ttbs){
        int s = (int)(Math.random()*(60-30)+30);
        hibs.add(Calendar.SECOND,s);
        hibs.add(Calendar.SECOND,ttbs);
        
        return hibs;
    }
    
    private String generateTTLS(){
        int s = (int)(Math.random()*(40-20)+20);
        return s+"";
    }
    
    private String convertString(Calendar t){
        return t.get(Calendar.HOUR_OF_DAY) + ":" + t.get(Calendar.MINUTE) + ":" + t.get(Calendar.SECOND);
    }
    
    public String[] generateDataTable(Calendar ini, int s){
        String [] table = new String[16];
        
        Calendar hip = generateHIP(ini,s);
        table[1] = convertString(hip);
        
        table[0] = generateID();           table[2]    = generateTTP();       
        table[3] = getQuantum();           table[4]    = generatePRI();       
        table[5] = "";                     table[6]    = generateSUCS();    
        
        Calendar hisuc1 = generateHISUC1(hip);
        table[7] = convertString(hisuc1);
        
        table[8]    = (new Integer(table[6])==50) ? "120" : generateTTSUCS();    table[9] = generateSUCS();
        
        Calendar hisuc2 = generateHISUC2(hisuc1, new Integer(table[8]));
        table[10]   = convertString(hisuc2);
        
        table[11]   = (new Integer(table[9])==50) ? "120" : generateTTSUCS();
        
        Calendar hibs = generateHIBS(hisuc2,new Integer(table[11]));
        table[12]   = convertString(hibs);
        
        table[13]   = generateTTBS();
        
        Calendar hils = generateHILS(hibs,new Integer(table[13]));
        table[14]   = convertString(hils);
        
        table[15]   = generateTTLS();
        return table;
    }
    
    private Calendar time;
    private static int id = 0;
    public static int QUANTUM = 5;
}