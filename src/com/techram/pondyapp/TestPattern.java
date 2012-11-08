package com.techram.pondyapp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestPattern {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str ="<p><img class=\"alignleft size-full wp-image-22167\" title=\"Central Minister Falgged off Puducherry - Mumbai Train\" src=\"http://puducherrynews.com/news/wp-content/uploads/2012/11/Central-Minister-Falgged-off-Puducherry-Mumbai-Train.jpg\" alt=\"Central Minister Falgged off Puducherry - Mumbai Train / மத்திய அமைச்சர் புதுச்சேரி - மும்பை ரயிலை துவக்கி வைத்தார்\" width=\"263\" height=\"193\" /><img class=\"alignleft size-full wp-image-22166\" title=\"Puducherry - Mumbai Train\" src=\"http://puducherrynews.com/news/wp-content/uploads/2012/11/Puducherry-Mumbai-Train.jpg\" alt=\"Puducherry - Mumbai Train / புதுச்சேரி - மும்பை ரயில்\" width=\"263\" height=\"193\" />புதுச்சேரி, நவ. 7: புதுச்சேரி – கன்னியாகுமரிக்கு ரயில் விடப்படும் என மத்திய அமைச்சர் ஆதிர் ரஞ்சன் சவுத்ரி கூறினார்.</p> <p>புதுவை-மும்பை ரயில் சேவை தொடக்க விழா புதுவை ரயில் நிலையத்தில் நேற்று நடந்தது. விழாவுக்கு மத்திய மந்திரி நாராயணசாமி தலைமை தாங்கினார். புதுவை சட்டமன்ற எதிர்க்கட்சி தலைவர் வைத்திலிங்கம் முன்னிலை வகித்தார். தென்னக ரயில்வேயின் கூடுதல் பொது மேலாளர் நாராயணன் வரவேற்று பேசினார். நிகழ்ச்சியில் மத்திய ரயில்வே இணை மந்திரி ஆதிர் ரஞ்சன் சவுத்ரி கலந்துகொண்டு கொடியசைத்து வைத்து புதிய ரயில் சேவையை தொடங்கி வைத்தார்.</p> <p>அப்போது அவர்  பேசியதாவது:</p> <p>புதுச்சேரி உள்நாட்டு, வெளிநாட்டு பயணிகள் அதிக அளவில் வந்து செல்லும் இடம். இது ஒரு ஆன்மிக பூமி. எனவே இங்கு கூடுதல் ரயில் வசதி தேவை.</p> <p>ஏற்கனவே இங்கிருந்து டெல்லி, அவுரா, புவனேஸ்வர் போன்ற பகுதிகளுக்கு ரயில் சேவை உள்ளது. தமிழகத்தின் தென்பகுதிகளும் ரயில்கள் மூலம் இணைக்கப்பட வேண்டும் என்று மத்திய மந்திரி நாராயணசாமி கோரிக்கை விடுத்துள்ளார். அவரது கோரிக்கை விரைவில் நிறைவேற்றப்படும். புதுவை ரயில் நிலையத்தில் பயணிகளுக்கு தேவையான வசதிகள் செய்து கொடுக்கப்படும்.</p> <p>ரயில்வே திட்டங்களை நிறைவேற்றுவதில் பாதி செலவினை மாநில அரசுகள் ஏற்றுக் கொண்டால் ரயில்வே திட்டங்களை விரைவாக முடிக்கலாம். புதுவையில் போக்குவரத்து நெருக்கடியை சமாளிக்க ரயில்வே மேம்பாலங்கள் கட்ட புதுவை அரசு 50 சதவீத நிதியை வழங்கவேண்டும் என்று கோரிக்கை விடுக்கிறேன். மத்திய மந்திரி நாராயணசாமி வைத்து கோரிக்கைகள் அனைத்தும் விரைவில் நிறைவேற்றப்படும்.</p> <p>இவ்வாறு அவர் பேசினார்.</p> <p>விழாவில் எம்.எல்.ஏ.க்கள் தேனீ.ஜெயக்குமார், நமச்சிவாயம், திருமுருகன், புதுவை ரயில் நிலைய மேலாளர் மணிராஜன், காங்கிரஸ் தலைவர் ஏ.வி.சுப்ரமணியன் மற்றும் காங்கிரஸ் நிர்வாகிகள் உள்பட பலர் கலந்து கொண்டனர்.</p> <p>முடிவில் திருச்சி கோட்ட மேலாளர் மஞ்சுளா ரங்கராஜன் நன்றி கூறினார்.</p> <p>இந்த ரயில் புதுச்சேரியிலிருந்து ஞாயிறு, செவ்வாய் மற்றும் புதன்கிழமைகளில் இரவு 8.15 மணிக்கு புறப்பட்டு செல்கிறது. மும்பை தாதரிலிருந்து ஞாயிறு, திங்கள், மற்றும் வெள்ளிக்கிழமைகளில் இரவு 9.30 மணிக்கு புறப்பட்டு வருகிறது. 18 பெட்டிகள் இந்த ரயிலில் ஏ.சி. 2 அடுக்கு பெட்டி ஒன்று, ஏ.சி. 3 அடுக்கு பெட்டி 2, 2ம் வகுப்பு படுக்கை வசதி பெட்டி 9, 3 பொது பெட்டிகள், ஒரு மாற்றுத்திறனாளிகளுக்கான இடவசதியுடன் கூடிய லக்கேஜ் மற்றும் பிரேக் வண்டி பெட்டிகள் என மொத்தம் 18 பெட்டிகள் உள்ளன.</p> <p>இந்த ரயில் புதுவையிலிருந்து செல்லும்போது விழுப்புரம், திருக்கோவிலூர், திருவண்ணாமலை, போளூர், ஆரணி ரோடு, வேலூர் கன்டோன்மெண்ட், காட்பாடி, ஜோலார்பேட்டை, பங்காரப்பேட்டை வழியாக யஷ்வந்த்பூர் சென்று அங்கிருந்து தாதர் செல்கிறது.</p>";
		Pattern p = Pattern.compile("<img[^>]+src=\"([^\"]+)\"[^>]+/>");
		Matcher m = p.matcher(str);
		boolean b = m.matches();
		System.out.println(m.group(0)); //prints one
	}

}
