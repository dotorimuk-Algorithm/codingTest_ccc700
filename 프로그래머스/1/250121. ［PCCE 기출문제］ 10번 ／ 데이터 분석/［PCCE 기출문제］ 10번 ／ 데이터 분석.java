class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};
        
        //분류 기준이 될 인덱스값 확보
        int num=0;
        switch(ext){
            case "code": 
                num = 0;
                break;
            case "date" : 
                num = 1;
                break;
            case "maximum" : 
                num = 2;
                break;
            case "remain" : 
                num = 3;
                break;
        }
    
        //배열 길이 지정      
        int cnt_j = 0; 
        for (int i = 0; i < data.length; i++) {
            if (data[i][num] < val_ext) {
                cnt_j++;
            }
        }
        answer = new int[cnt_j][data[0].length];
        
        //데이터 뽑기
        int j=0; 
        for(int i=0; i<data.length; i++){
            if(data[i][num]<val_ext){
                answer[j] = data[i];
                j++;
            }
        }
        
        //오름차순 정렬
        int sort_num=0;
        switch(sort_by){
            case "code":
                sort_num = 0;
                break;
            case "date" : 
                sort_num = 1;
                break;
            case "maximum" : 
                sort_num = 2;
                break;
            case "remain" : 
                sort_num = 3;
                break;
        }
        
        for (int i = 0; i < answer.length - 1; i++) {
            for (int k = 0; k < answer.length - 1 - i; k++) {
                if (answer[k][sort_num] > answer[k + 1][sort_num]) {
                    int[] tmp = answer[k];
                    answer[k] = answer[k + 1];
                    answer[k + 1] = tmp;
                }
            }
        }
        
        
        return answer;
    }
}