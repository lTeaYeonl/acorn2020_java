package test.dto;

public class MemoDto {
   //회원 한명의 정보를 담을 필드 선언
   private int num;
   private String content;
   private String date;
   //default 생성자 만들기
   public MemoDto() {}
      //인자로 필드에 저장할 값을 전달받는 생성자
      public MemoDto(int num, String content, String date) {
         super();
         this.num = num;
         this.content = content;
         this.date = date;
      }
      //필드의 접근 메소드 setter, getter 메소드
      public int getNum() {
         return num;
      }
      public void setNum(int num) {
         this.num = num;
      }
      public String getContent() {
         return content;
      }
      public void setContent(String content) {
         this.content = content;
      }
      public String getDate() {
         return date;
      }
      public void setDate(String date) {
         this.date = date;
      }
      
   }