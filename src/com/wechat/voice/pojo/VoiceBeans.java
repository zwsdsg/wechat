package com.wechat.voice.pojo;

public class VoiceBeans {

	private Integer voice_id;
	private String voice_name;
	private String voice_summary;
	private String voice_cover;
	private Integer voice_countChapter;
	private String voice_anchorName;
	private String Voice_anchors;
	public Integer getVoice_id() {
		return voice_id;
	}
	public void setVoice_id(Integer voice_id) {
		this.voice_id = voice_id;
	}
	public String getVoice_name() {
		return voice_name;
	}
	public void setVoice_name(String voice_name) {
		this.voice_name = voice_name;
	}
	public String getVoice_summary() {
		return voice_summary;
	}
	public void setVoice_summary(String voice_summary) {
		this.voice_summary = voice_summary;
	}
	public String getVoice_cover() {
		return voice_cover;
	}
	public void setVoice_cover(String voice_cover) {
		this.voice_cover = voice_cover;
	}
	public Integer getVoice_countChapter() {
		return voice_countChapter;
	}
	public void setVoice_countChapter(Integer voice_countChapter) {
		this.voice_countChapter = voice_countChapter;
	}
	public String getVoice_anchorName() {
		return voice_anchorName;
	}
	public void setVoice_anchorName(String voice_anchorName) {
		this.voice_anchorName = voice_anchorName;
	}
	public String getVoice_anchors() {
		return Voice_anchors;
	}
	public void setVoice_anchors(String voice_anchors) {
		Voice_anchors = voice_anchors;
	}
	public VoiceBeans(Integer voice_id, String voice_name,
			String voice_summary, String voice_cover,
			Integer voice_countChapter, String voice_anchorName,
			String voice_anchors) {
		super();
		this.voice_id = voice_id;
		this.voice_name = voice_name;
		this.voice_summary = voice_summary;
		this.voice_cover = voice_cover;
		this.voice_countChapter = voice_countChapter;
		this.voice_anchorName = voice_anchorName;
		Voice_anchors = voice_anchors;
	}
	public VoiceBeans() {
		super();
	}
	@Override
	public String toString() {
		return "VoiceBeans [voice_id=" + voice_id + ", voice_name="
				+ voice_name + ", voice_summary=" + voice_summary
				+ ", voice_cover=" + voice_cover + ", voice_countChapter="
				+ voice_countChapter + ", voice_anchorName=" + voice_anchorName
				+ ", Voice_anchors=" + Voice_anchors + "]";
	}
	
}
