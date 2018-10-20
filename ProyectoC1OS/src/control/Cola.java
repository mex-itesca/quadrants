package control;

public class Cola{
    public Cola(){
        index = -1;
        c = new Proceso[5];
    }

    public void add(){
        if(index>=c.length-1)
            resize();
        
        c[++index] = new Proceso();
        if(initial != 4)orderByPRI();
    }

    private void orderByPRI(){
        for(int i=0;i<index-1;i++){
            for(int j=0;j<index-1;j++){
                if(new Integer(c[j].getPRI()) < new Integer(c[j+1].getPRI())){
                    Proceso tmp = c[j+1];
                    c[j+1] = c[j];
                    c[j] = tmp;
                }
            }
        }
    }
    
    public boolean empty(){
        return index == -1;
    }
    
    public void resize(){
        Proceso []tmp = new Proceso[c.length*2];
        
        for(int i=0;i<=index;i++)
            tmp[i] = c[i];
        c = tmp;
    }

    private int find(String id){
        for(int i=0;i<=index;i++){
            if(c[i].getID().equals(id))
                return i;
        } return -1;
    }
    
    public Proceso get(int i){
        if(i<0 || i>index) return null;
        return c[i];
    }

    public Proceso delete(String id){
        int ind = find(id);
        int count = 0;
        Proceso tmp = null;

        if(ind != -1 ){
            Proceso []ctmp = new Proceso[index-1];
            for(int i=0;i<=index;i++){
                if(i!=ind)
                    ctmp[count] = c[i];
                else {
                    tmp = c[i];
                    count--;
                }
                count++;
            } c = ctmp;
        }
        
        return tmp;
    }
    
    public void clean(){
        index = -1;
        Proceso.reset();
    }
    
    private int initial = 0;
    private int index;
    private Proceso [] c;
}