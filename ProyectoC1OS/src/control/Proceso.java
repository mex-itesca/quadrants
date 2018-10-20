package control;

import java.util.Calendar;

public class Proceso{
    public Proceso(){ 
        this.time = Calendar.getInstance();
        cfgProcess();
    }

    /* ............................................................................................................. */
    /* .........................................Operaciones......................................................... */
    /* ............................................................................................................. */
    
    private String  generateHIP(){
        time.add(Calendar.SECOND, (ID == 100) ? SEG : (SEG += (((int)(Math.random()*(60-30)+30)))));
        return setFormat();
    }
    
    private String generateID(){
        return "" + (ID+=10);
    }
    
    private String generateTTP(){
        return "" + ((int)(Math.random()*(120-60)+60));
    }
    
    private String generatePRI(){
        return "" + ((int)(Math.random()*11));
    }
    
    private String generateStatus(){
        return "";
    }
    
    private String generateSUCS(){
        do{
            int suc = ((int)(Math.random()*(60-20)+20));
            if(suc%10 == 0) return ""+suc;
        }while(true);
    }
    
    private String generateHISUC1(){
        int s = (int)(Math.random()*(60-30)+30);
        time.add(Calendar.SECOND,s);
        
        return setFormat();
    }
    
    private String generateTTSUCS(){
        return "" + ((int)(Math.random()*(40-20)+20));
    }
    
    private String generateHISUC2(int ttsuc1){
        int s = (int)(Math.random()*(60-30)+30);
        time.add(Calendar.SECOND,s);
        time.add(Calendar.SECOND,ttsuc1);
        
        return setFormat();
    }
    
    private String generateHIBS(int ttsuc2){
        int s = (int)(Math.random()*(60-30)+30);
        time.add(Calendar.SECOND,s);
        time.add(Calendar.SECOND,ttsuc2);
        
        return setFormat();
    }
    
    private String generateTTBS(){
        return "" + ((int)(Math.random()*(40-20)+20));
    }
    
    private String generateHILS(int ttbs){
        int s = (int)(Math.random()*(60-30)+30);
        time.add(Calendar.SECOND,s);
        time.add(Calendar.SECOND,ttbs);
        
        return setFormat();
    }
    
    private String generateTTLS(){
        return "" + ((int)(Math.random()*(40-20)+20));
    }
    
    public static void reset(){
        ID = 90;
        SEG = 120;
    }

    private void cfgProcess(){
        data[id]      = generateID();
        data[hip]     = generateHIP();
        data[ttp]     = generateTTP();
        data[quantum] = "5";
        data[pri]     = generatePRI();
        data[status]  = generateStatus();
        data[suc1]    = generateSUCS();
        data[hisuc1]  = generateHISUC1();
        data[ttsuc1]  = (new Integer(data[suc1])==50) ? "120" : generateTTSUCS();
        data[suc2]    = generateSUCS();
        data[hisuc2]  = generateHISUC2(new Integer(ttsuc1));
        data[ttsuc2]  = (new Integer(data[suc2])==50) ? "120" : generateTTSUCS();
        data[hibs]    = generateHIBS(new Integer(ttsuc2));
        data[ttbs]    = generateTTBS();
        data[hils]    = generateHILS(new Integer(ttbs));
        data[ttls]    = generateTTLS();
    }
    
    /* ............................................................................................................. */
    /* .........................................Gettes.............................................................. */
    /* ............................................................................................................. */
    
    public String[] getData(){
        return data;
    }

    public String getID(){
        return data[id];
    }

    public String getHIP(){
        return data[hip];
    }

    public String getTTP(){
        return data[ttp];
    }

    public String getQuantum(){
        return data[quantum];
    }

    public String getPRI(){
        return data[pri];
    }

    public String getStatus(){
        return data[status];
    }

    public String getSUC1(){
        return data[suc1];
    }

    public String getHISUC1(){
        return data[hisuc1];
    }

    public String getTTSUC1(){
        return data[ttsuc1];
    }

    public String getSUC2(){
        return data[suc2];
    }

    public String getHISUC2(){
        return data[hisuc2];
    }

    public String getTTSUC2(){
        return data[ttsuc2];
    }

    public String getHIBS(){
        return data[hibs];
    }

    public String getTTBS(){
        return data[ttbs];
    }

    public String getHILS(){
        return data[hils];
    }

    public String getTTLS(){
        return data[ttls];
    }
    
    /* ............................................................................................................. */
    /* .........................................Settes.............................................................. */
    /* ............................................................................................................. */
    
    public void setID(String nId){
        data[id] = nId;
    }

    public void setHIP(String nHip){
        data[hip] = nHip;
    }

    public void setTTP(String nTtp){
        data[ttp] = nTtp;
    }

    public void setQuantum(String nQuant){
        data[quantum] = nQuant;
    }

    public void setPRI(String nPri){
        data[pri] = nPri;
    }

    public void setStatus(String nStatus){
        data[status] = nStatus;
    }


    public void setTTSUC1(String nTtsuc1){
        data[ttsuc1] = nTtsuc1;
    }

    public void setTTSUC2(String nTtsuc2){
        data[ttsuc2] = nTtsuc2;
    }

    public void setHIBS(String nHibs){
        data[hibs] = nHibs;
    }

    public void setTTBS(String nTtbs){
        data[ttbs] = nTtbs;
    }

    public void setHILS(String nHils){
        data[hils] = nHils;
    }

    public void setTTLS(String nTtls){
        data[ttls] = nTtls;
    }

    private String setFormat(){
        String hour = "";
        
        hour += (((time.get(Calendar.HOUR_OF_DAY)+"").length()==1) ? "0"+time.get(Calendar.HOUR_OF_DAY) : time.get(Calendar.HOUR_OF_DAY)) + ":";
        hour += (((time.get(Calendar.MINUTE)+"").length()==1) ? "0"+time.get(Calendar.MINUTE) : time.get(Calendar.MINUTE)) + ":";
        hour += (((time.get(Calendar.SECOND)+"").length()==1) ? "0"+time.get(Calendar.SECOND) : time.get(Calendar.SECOND));
            
        return  hour;
    }

    private static int SEG = 120;
    private static int ID = 90;

    private Calendar time;
    
    private String []data = new String[16];
    private boolean tSuc1 = false;
    private boolean tSuc2 = false;
    
    private final int id = 0, hip = 1, ttp = 2, quantum = 3;
    private final int pri = 4, status = 5, suc1 = 6, hisuc1 = 7;
    private final int ttsuc1 = 8, suc2 = 9, hisuc2 = 10, ttsuc2 = 11;
    private final int hibs = 12, ttbs = 13, hils = 14, ttls = 15;
}