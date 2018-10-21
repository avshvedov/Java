package javaapplication17;

class Picture {
    
    private int pictureID;
    private String  pictureName;
    private int artistID;
    
    Picture (String s){
        String[] r=s.split(",");
        pictureName = r[1]; 
        pictureID = Integer.valueOf(r[0]);
        artistID = Integer.valueOf(r[2]);
    }
    
    @Override
    public String toString(){
        return "№" + pictureID + ", Название картины: " + pictureName;
    }
}

class Author{
    private String authorID;
    private String  authorName;
    private Picture[] pictures;
    Author(String s1, String[] s2) {
        String[] r =s1.split(",");
        authorID = r[0];
        authorName = r[1];
        int n = 0;
        for (String s:s2){
            if (authorID.equals(s.substring(s.length()-3))) n++;
        }
        pictures = new Picture[n];
        int i = 0;
        for (String s:s2)
            if (authorID.equals(s.substring(s.length()-3))) {
                pictures[i++] = new Picture(s);
            }
    }
    @Override
    public String toString(){
        String r = "\n";
        for(Picture s:pictures) {
            r+=s+"\n";
        }
        r+="\n";
        return "ID:" + authorID + " Имя:" + authorName + r;
    }
}

public class JavaApplication17 {
    public static void main(String[] args) {
        String[] authors ={"100,Крупень", "101,Беляев", "103, Кручинкин"};
        String[] pictures = {"1001,Старая Москва,100",
                            "1002,Пионы,100",
                            "1003,Даниловский монастырь,101",
                            "1004,Веселый денек,101",
                            "1005,Старая Москва,103",                        
        }; 
        
        final int N = authors.length;
        Author[] r = new Author[N];
        for (int i = 0; i < N; i++)
            r[i] = new Author(authors[i], pictures);
        
        for (Author s:r)
            System.out.println(s);
       
   }
    
}