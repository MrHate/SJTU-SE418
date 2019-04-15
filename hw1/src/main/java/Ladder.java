package com.dgy.Ladder;

import java.util.*;
import java.io.*;

public class Ladder{
	public static void main(String[] args){
		String  s1="",s2="";
		try{
			s1 = args[0];
			s2 = args[1];
		}
		catch(Exception e){
			System.out.println("Two and only two args needed.");
		}
		if(!s2.equals("")){
			System.out.println(generateLadder(s1,s2));
		}
	}
	
	public static ArrayList<String> generateDict(String filename){
		ArrayList<String> res = new ArrayList<String>();
		InputStream is = Ladder.class.getClassLoader().getResourceAsStream(filename);

        try {
			//String pathname = getDictPath("dictionary.txt");
			//FileReader reader = new FileReader(new File(pathname));
            //BufferedReader br = new BufferedReader(reader);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
         
            String line;
            while ((line = br.readLine()) != null) {
                //System.out.println(line);
				res.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

		return res;
	}
	
	public static ArrayList<String> generateLadder(String begin, String end){
		Queue<String> queue = new LinkedList<String>();
		ArrayList<String> words = generateDict("dictionary.txt");
		ArrayList<String> trace = new ArrayList<String>();
		ArrayList<String> res = new ArrayList<String>();
		Map<String,String> prev = new HashMap<String,String>();
		Map<String,Integer> dist = new HashMap<String,Integer>();
		   
		begin=begin.toLowerCase();
		end=end.toLowerCase();

		queue.offer(begin);
		trace.add(begin);
		dist.put(begin,0);
		String cur="";
		while(!queue.isEmpty()){
			cur=queue.poll();
			if(cur.equals(end))break;
			for(int i=0;i<cur.length();i++){
				for(char j='a';j<='z';j++){
					char[] arr=cur.toCharArray();
					arr[i]=j;
					String tstr=new String(arr);
					int curDist=dist.get(cur);
					int tDist;
					try{
						tDist=dist.get(tstr);
					}
					catch(NullPointerException e){
						tDist = Integer.MAX_VALUE;
					}
					if(words.contains(tstr)){
						if(trace.contains(tstr)){ 
							if(curDist+1 < tDist){
								dist.put(tstr,curDist+1);
								prev.put(tstr,cur);
							}
						}
						else{
							prev.put(tstr,cur);
							dist.put(tstr,curDist+1);
							queue.offer(tstr);
						}
						trace.add(tstr);
					}
				}
			}
		}
		
		if(!cur.equals(end)){
			System.out.println("Cannot generate a ladder.");
		}	
		else{
			res.add(cur);
			while(prev.get(cur)!=null){
				res.add(prev.get(cur));
				cur=prev.get(cur);
			}
		}
		return res;
	}

}
