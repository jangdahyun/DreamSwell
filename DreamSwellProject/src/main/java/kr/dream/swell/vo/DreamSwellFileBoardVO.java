package kr.dream.swell.vo;

import lombok.Data;

@Data
public class DreamSwellFileBoardVO {
	private Long idx;
	private String filepath;
	private String url;
	
	private Long ref; //board idx
	
}
