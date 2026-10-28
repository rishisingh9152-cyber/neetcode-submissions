class MedianFinder {
    List<Integer>list;

    public MedianFinder() {
        list=new ArrayList<>();
    }
    
    public void addNum(int num) {
        list.add(num);
        
    }
    
    public double findMedian() {
        Collections.sort(list);
        int size=list.size();
        if(size%2==0){
            return (list.get(size/2)+list.get(size/2-1))/2.0;
        }
        else{
            return list.get(size/2);
        }
    }
}
