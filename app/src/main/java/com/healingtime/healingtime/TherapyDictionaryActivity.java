package com.healingtime.healingtime;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class TherapyDictionaryActivity extends AppCompatActivity {

    // Declare Variables
    ListView list;
    ListViewAdapter adapter;
    EditText editsearch;
    String[] aroma_name;
    String[] aroma_sub_name;
    String[] aroma_extract_part;
    String[] aroma_extract_method;
    String[] aroma_country_origin;
    String[] aroma_detailed_instructions;
    String[] aroma_color;
    String[] aroma_blending_oil;
    String[] aroma_history;
    String[] aroma_caution;
    int[] icon;
    ArrayList<WorldPopulation> arraylist = new ArrayList<WorldPopulation>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.therapy_dictionary);

        // Generate sample data
        aroma_name = new String[] {"Basil", "Bergamot - Calabrian", "Cedarwood Atlas", "Citronella Ceylon", "Clary Sage", "Cypress French", "Eucalyptus Blue Gum", "Fennel Sweet", "Frankincense", "Geranium Egypt", "Ginger", "Grapefruit White",
                "Juniperberry", "Lavender (Lavandin Grosso)", "Lavender", "Lavender bulgarian", "Lavender French", "Lavender Mont Blanc", "Lavender Population", "Lemon(Cold pressed)", "Lemongrass Cochin", "Lime(Cold Pressed)", "Litsea Cubeba(May Chang)",
                "Mandarin(Cold Pressed)", "Marjoram", "Myrrh", "Orange Sweet", "Palmarosa", "Patchouli", "Pine", "Pine Scotch", "Peppermint Arvensis or Cornmint",
                "Piperita Mentha", "Rose Geranium", "Rosemary - Tunisia", "Rosewood", "Spearmint", "Tangerine", "Tea Tree", "Thyme", "Vetiver", "Ylang Ylang 1st", "Ylang Ylang 3rd"};

        aroma_sub_name = new String[] {"Ocimum basilicum", "Citrus bergamia", "Cedrus atlantica", "Cymbopogon nardus", "Salvia sclarea", "Cupressus sempervirens", "Eucalyptus Radiata", "Foeniculum vulgare dulce", "Boswellia carteri",
                "Pelargoneum Graveolens", "Zingiber officinalis", "Citrus Paradisi","Juniperus Communis", "Angustifolia x Latifolia", "Lavandula officinalis","Lavandula Angustifolia Miller", "Lavandula dentata",
                "Lavandula angustifolia", "Lavandula angustifolia","Citrus limonum", "Cymbopogon flexuosus", "Citrus aurantifolia", "Litsea cubeba","Citrus Reticulata var. 'Mandarin'",
                "Origanum marjorana","Commiphora myrrha","Citrus sinensis","Cymbopogon martinii", "Pogostemon cablin", "Pinus pinaster", "Pinus sylvestris", "Mentha arvensis", "Mentha piperita", "Pelargoneum Roseum",
                "Rosmarinus Officinails", "Aniba rosaeodora", "Mentha spicata", "Citrus Reticulata Blanco var. 'Tangerine'", "Melaleuca alternifolia", "Thymus vulgaris", "Vetiveria zizanoides", "Cananga odorata","Cananga odorata"};

        icon = new int[] {R.drawable.aroma_basil, R.drawable.aroma_bergamot_calabrian, R.drawable.aroma_cedarwood_atlas, R.drawable.aroma_citronella_ceylon, R.drawable.aroma_clary_sage, R.drawable.aroma_cypress_french,
                R.drawable.aroma_eucalyptus_blue_gum, R.drawable.aroma_fennel_sweet, R.drawable.aroma_frankincense, R.drawable.aroma_geranium_egypt, R.drawable.aroma_ginger, R.drawable.aroma_grapefruit_white,
                R.drawable.aroma_juniperberry, R.drawable.aroma_lavender, R.drawable.aroma_lavender, R.drawable.aroma_lavender, R.drawable.aroma_lavender, R.drawable.aroma_lavender, R.drawable.aroma_lavender,
                R.drawable.aroma_lemon, R.drawable.aroma_lemongrass_cochin, R.drawable.aroma_lime, R.drawable.aroma_litsea_cubeba, R.drawable.aroma_mandarin, R.drawable.aroma_marjoram, R.drawable.aroma_myrrh,
                R.drawable.aroma_orange_sweet, R.drawable.aroma_palmarosa, R.drawable.aroma_patchouli, R.drawable.aroma_pine, R.drawable.aroma_pine_scotch, R.drawable.aroma_peppermint, R.drawable.aroma_peppermint,
                R.drawable.aroma_rose_geranium, R.drawable.aroma_rosemary, R.drawable.aroma_rosewood, R.drawable.aroma_spearmint, R.drawable.aroma_tangerine, R.drawable.aroma_tea_tree, R.drawable.aroma_thyme,
                R.drawable.aroma_vetiver, R.drawable.aroma_ylang_ylang, R.drawable.aroma_ylang_ylang};

        aroma_extract_part = new String[] {"잎, 꽃", "열매껍질", "목질부", "수지", "잎, 꽃", "솔잎, 작은가지", "잎", "씨앗", "수지", "X", "뿌리", "열매껍질", "베리(열매)", "X", "꽃", "꽃", "꽃", "꽃", "꽃", "Peel of the fruit", "잎", "열매껍질",
                "열매", "열매껍질","꽃, 잎", "수지", "열매껍질", "잎", "잎", "솔잎", "솔잎, 작은가지", "꽃이 핀 허브", "꽃이 핀 허브", "잎, 줄기", "허브", "목질부", "꽃", "열매껍질", "잎", "상단부(꽃, 잎등)", "뿌리", "꽃", "꽃"};

        aroma_extract_method = new String[] {"수증기증류법", "냉압착법", "수증기증류법", "증류법", "증류법", "증류법", "증류법", "수증기증류법", "증류법", "X", "증류법", "냉압착법", "수증기증류법", "증류법", "수증기증류법 (40/42% Ester)",
                "수증기증류법", "수증기증류법", "수증기증류법", "수증기증류법", "냉압착법", "증류법", "냉압착법", "증류법", "냉압착법", "증류법", "증류법", "냉압착법", "증류법", "증류법", "증류법", "수증기증류법", "증류법", "증류법", "수증기증류법",
                "수증기증류법", "수증기증류법", "증류법", "냉압착법", "증류법", "증류법", "증류법", "증류법", "증류법"};

        aroma_country_origin = new String[] {"이탈리아", "이탈리아", "USA", "스리랑카", "불가리아","X","중국","프랑스","X","X","프랑스","프랑스","X","프랑스","프랑스","X","프랑스","프랑스","프랑스",
                "이탈리아","인도","이탈리아","호주","X","스페인","아프리카","브라질","인도","X","USA","헝가리","USA","USA","프랑스","튀니지","브라질","USA","X","호주","스페인","자바","프랑스","프랑스"};

        aroma_detailed_instructions = new String[] {"일년생 식물인 바질은 20~50 센티가량 자라며 개화시에는 보라색과 흰색의 꽃들이 송이를 지어 피고 타원형의 끝이 뾰족한 녹색의 잎을 가졌습니다. 아유로베딕에서는 바질은 연민과 믿음을 증강시키고 정화하는 능력이 있다고 소중히 여겨졌습니다. 바질은 부비강염에 좋고, 소화를 촉진하며 순환계 특히 호흡계를 자극합니다.",
                "버가못 나무는 4미터가량 자라나며 별모양의 꽃과 연한 나뭇잎을 가졌고 감귤류의 오렌지와 그레이프프룻을 어중간하게 닮은 배 모양의 열매를 가졌습니다. 버가못은 초록색에서 노란색으로 무르익습니다. 버가못오일은 우울증, 스트레스, 긴장, 공포, 히스테리, 식욕부진, 건선, 습진, 회복기때의 치료로 사용하실 수 있습니다.",
                "피라미드형태의 장대한 상록수로 131피트까지 자랍니다. 나무 자체에서 높은 퍼센테이지의 에센셜오일을 함유하고 있어 강한 아로마가 있습니다. 시더우드의 에센셜오일은 증기증류로 얻어집니다. 시더우드 아틀라스는 여드름, 관절염, 기관지염, 기침, 방광염, 비듬, 피부염, 스트레스의 증상이 있을때 사용하며 시더우드는 따듯한 기운과 기분을 좋게 하며 안정을 주고 기운나게 해줍니다. 최음제로도 사용되고 있습니다.",
                "시트로넬라오일은 스리랑카와 자바가 원산지인 약 1미터가량 자라는 다년생의 탄력성이 좋은 풀(Cymbopogon nardus)에서 추출됩니다. 시트로넬라셀리온은 마취제, 방취제, 살충제, 강장제로의 효능 성분이 있습니다. 많은 시판용 상업방충제품에 시트로넬라셀리온이 함유되어 있으며 시더우드와 혼합하여 자주 사용됩니다. (시더우드가 벌레들이 좋아하는 향을 냅니다) 시트로넬라 오일은 비누, 초등에도 사용되며 마사지할때도 쓰이고 피부나 머리의 발한증에도 사용됩니다.",
                "클라리세이지는 다년생허브로 1미터가량 자라며 크고 털이 많은 잎과 작고 푸른빛이 도는 보라색 꽃을 가졌습니다. 아로마테라피스들은 항우울제, 진경제, 방취제, 월경촉진제, 저혈압치료제, 신경진정제, 진정제, 강장제에로의 클라리세이지를 효능을 주시합니다. 천식의 발작을 안정시키는데 도움을 준다는 기록도 있습니다.",
                "사이프러스는 다년생의 원뿔형의 나무로 약 28 미터 가량 자라납니다. 진녹색의 잎들과 작은 꽃과 둥근 안에 씨가 있는 밤회색의 솔방울을 가졌으며 적노란색의 내구성이 있는 단단한 목질부를 가졌습니다. 사이프러스 프렌치 에센셜오일은 발한증 (특히 발 부위)에 사용되며 치질, 월경과다, 지성피부, 류마티스, 정맥류의 치료에 사용되며 아로마테라피스트들은 휴식과 신경안정을 위한 에센셜오일로 사용합니다. 수렴제로 스킨케어제품에 사용되기도 합니다.",
                "유칼립투스나무는 90미터까지 자라는 아름답고 큰 관목수입니다. 어린나무는 타원형이 푸르슴한 녹색 잎을 자라나면 길고 좁은 노란색의 잎과 크림색의 꽃과 옅은 회색의 나무껍질을 가지게 됩니다. 유칼립투스 에센셜오일은 피부질환에(화상, 수포, 상처, 벌레물린곳, 이, 피부감염) 아주 좋습니다. 또한 감기나 독감증세때 사용하기 좋으며 근육과 관절 통증에 사용하였다는 역사도 있습니다.",
                "다년생 식물로 2미터까지 자라며 깃이 있는 잎과 황금빛노란 꽃을 가졌습니다. 펜넬스윗은 살균제, 진경제, 구풍제, 정화제, 이뇨제, 거담제, 설사약, 흥분제, 소화제, 구충제로의 효과가 인정되고 있으며 기운을 돋우고 회목시키며 자극하고 따듯하게 한다고 믿어지고 있습니다.",
                "프랑킨센스 나무는 중동지역이 원산지이며 작고 풍부한 잎을 가지고 있으며 꽃은 흰색이거나 연한 핑크색입니다. 프랑킨센스오일은 살균, 수렴, 구풍제, 소화촉진, 이뇨제, 진정제, 강장제, 거담제등의 치료 성분이 있습니다.",
                "수증기증류법으로 추출한 옅은 연두색의 제라늄이집트오일은 여드름, 타박상, 화상, 상처, 피부염, 습진, 이, 방충제, 백선, 혈액순환저하, 인후염 치료에 도움을 주는 다목적 오일입니다. ",
                "진저는 다년생 허브로 3~4 피트가량 자라며 두꺼운 덩어리 줄기의 근경을 가지고 있는 것이 특징입니다. 진저오일은 아로마테라피스들이 감기와 독감, 구토(멀미, 입덧), 근육통(특히 허리), 혈액순환, 에 관절의 통증에 사용하였습니다. 진저는 몸을 따듯하게 하는 성분이 있어 외로움과 우울증을 떨칠수 있게 도와주며 활기를 주는 성분으로 최음제의 효과 있다고도 합니다.",
                "그레이프푸룻의 원산지는 아시아이지만 지금은 미국, 프랑스, 브라질, 이탈리아에서 경작됩니다. 그레이프푸룻 나무는 크고 반짝거리는 윤나는 잎을 가졌으며 10 미터까지 크며 하얗고 큰 꽃과 옅은 노란색의 열매를 가졌습니다. 그레이프푸룻화이트 에센셜오일은 기운을 상승시키며 근육의 피로와 경직을 도와줍니다. 울혈됨음 정화시켜주고 지성피부와 여드름 피부에 사용하시면 좋습니다. 그레이프푸룻 오일은 네출럴 토너로 크림이나 로션에 첨가되기도 하며 의학적으로 확인된바는 없지만 머리카락을 잘 자라게 한다고 믿어지고 있습니다.",
                "주니퍼베리는 3~35피트가량의 작은 관목수이며 고도 8808피트에서 15,400피트 사이의 히말리아지역에서 자라납니다. 주니퍼베리 에센셜오일은 체력을 유지하고 활력과 기력을 강화하는데 도움을 주며 명상시 좋습니다. 이뇨작용과 정화와 청결작용을 하여 체중감량과 디톡스블렌드로 인기가 있습니다. ",
                "라벤딘은 투루라벤더와(L. angustifolia) 스파이크라벤터(L. latifolia).의 교배종입니다. 전반적으로 투루라벤터보다 크며 목질의 줄기를가지고 있습니다. 향기는 라벤더와 매우 비슷하며 약간 더 샤프합니다. 이 식물은 1미터 가량 자라나며 길고 얖은 청보라색의 꽃을 피어납니다. 식물 전체에 오일 분비기관이 덮고 있습니다. 라벤더 40/42는 모든 라벤더의 대부분의 플로랄향을 가졌습니다. 테라퓨틱 등급은 가장 낮지만 몇 개의 강한 효능이 있습니다. 이 효능에는 항우울제, 진경제, 바우치제, 강장제, 상처제료제, 혈압강화제, 월경촉진제 등이 포함됩니다. 또한 피부가려움과 벌레물림, 화상에도 자주 사용됩니다.",
                "이 식물은 1미터 가량 자라나며 길고 얖은 청보라색의 꽃을 피어납니다. 식물 전체에 오일 분비기관이 덮고 있습니다. 라벤더 40/42는 모든 라벤더의 대부분의 플로랄향을 가졌습니다. 테라퓨틱 등급은 가장 낮지만 몇 개의 강한 효능이 있습니다. 이 효능에는 항우울제, 진경제, 바우치제, 강장제, 상처제료제, 혈압강화제, 월경촉진제 등이 포함됩니다. 또한 피부가려움과 벌레물림, 화상에도 자주 사용됩니다.",
                "이 식물은 상록의 견고한 관상수로 1미터가량 자라며 옅은 녹색과 좁은 선형의 잎과 청보라 꽃을 가지고 있습니다. 라벤더불가리안은 진경제, 마취제, 구풍제, 방취제, 살균제, 이뇨제, 담즘배출촉진제 등의 사용에 이용되며 약초상에 따르면 라벤더 에센셜 오일이화상과 피부치료에는 가장 흔희 사용하는 오일이라 합니다. 라벤더 불가리안은 테라퓨틱등급이 라벤더 퍼퓰레이션과 종종 비교되며 라벤더불가리안의 향은 라벤더프렌치와는 약간 다릅니다. 좀더 라벤더꽃에 가까운 향이나지만 그 효능은 라벤더퍼퓰레이션과 비슷합니다.",
                "상록의 견고한 관상수로 1미터가량 자라며 옅은 녹색과 좁은 선형의 잎과 청보라 꽃을 가지고 있습니다. 라벤더 프렌치는 진통제, 진경제, 방취제, 구풍제등에 사용되며 라벤터 오일은 가장유용하며 다목적인 테라퓨틱 에센셜 오일입니다. 약초상에 따르면 라벤더 에센셜 오일이화상과 피부치료에는 가장 흔희 사용하는 오일이라 합니다. 라벤더프렌지는 아로마테라피스트들과 마사지사에게 가장 인기있는 오일입니다. 테라퓨틱 퀄리티와 향기로은 플로럴향을 가졌습니다.",
                "이 식물은 상록의 견고한 관상수로 1미터가량 자라며 옅은 녹색과 좁은 선형의 잎과 청보라 꽃을 가지고 있습니다. 라벤더 몽블랑은 진통제, 진경제, 방취제, 구풍제등에 사용되며 라벤터 오일은 가장유용하며 다목적인 테라퓨틱 에센셜 오일입니다. 약초상에 따르면 라벤더 에센셜 오일이화상과 피부치료에는 가장 흔희 사용하는 오일이라 합니다.",
                "이 식물은 상록의 견고한 관상수로 1미터가량 자라며 옅은 녹색과 좁은 선형의 잎과 청보라 꽃을 가지고 있습니다. 라벤더 퍼퓰레이션은 진통제, 진경제, 방취제, 구풍제등에 사용되며 라벤터 오일은 가장유용하며 다목적인 테라퓨틱 에센셜 오일입니다. 약초상에 따르면 라벤더 에센셜 오일이화상과 피부치료에는 가장 흔희 사용하는 오일이라 합니다.",
                "레몬오일은 타원형의 레몬과실의 껍질에서 추출합니다. 레몬나무는 10~12피트 정도 자라며 무성한 나뭇잎으로 덮여 과실은 드문드문 있습니다. 레몬 나무는 따듯하고 안정된 기후에서 자라며 열대나 아열대 지방에서 주로 경작됩니다. 순환계, 혈류량, 정맥류 스트레스를 줄이고, 적혈구 세포의 활력을 복원 빈혈 현상을 줄이고, 감염성 질환에 대한 신체 도와 백혈구를 자극하면서 소화 기능을 촉진한다. 백혈구 세포를 자극, 상처 나 외상 다양한 형태의 출혈, 적용하고 상처를 치유하는 데 도움이, 전체 소화 기관, 위, 궤양 등을 따라 조정이 어느 정도 효과가있다. 특히 정맥류의 치료를위한 순환 시스템의 컨디셔닝, 고혈압 감기는 발열, 소화, 안티 모기에 물림, 잇몸의 염증, 구강 궤양에 도움, 피부 노화 속도를 저하 방지도 적용 할 수있다.",
                "다년생식물로 30~50 센티가량 자라며 적색의 대와 증류법을 사용하여 오일을 추출해내는 잎과 같은 빨리 자라나는 풀을 가졌습니다. 신경계 피로 회복, 코감기 예방, 리프레쉬 효과, 데오도런트 효과, 피부 불순물 제거 등 레몬그라스 오일은 옐로브라운의 색상을 가졌으며 신선한 잎과 부분적으로 건조한 잎에서 추출됩니다.",
                "라임나무는 작은상록수로 레몬과 비슷한 쓴 열매를 가졌습니다. 라임은 녹색이며 라임열매 안의 색도 녹색입니다. 라임에센셜오일 싱싱하며 상쾌한 시트러스 향을 가졌으며 아로마테라피스트들은 원기와 활력을 불어 넣기 위해 사용하였으며 지성피부를 깨끗하게 하는데 도움을 주는 수렴수로도 사용됩니다.",
                "매이챙은 작은 식물로 열대지방에서 찾아볼 수 있습니다. 잎은 보통 녹색빛이며 레몬 같은 향이 납니다. 작은 펩퍼같이 생각 열매에서 에센셜 오일이 추출됩니다. 매이챙은 안정과 항염효과가 뛰어납니다. 수렴제, 살균제, 살충제, 혈압강화제, 흥분제, 강장제에 사용되기도 합니다.",
                "오랜지과의 식물로 만다린나무는 작은 잎과 열매를 가졌으며 오렌지나무보다 보다 작습니다. 만다린과 탠저린은 같은 종으로 다양하게 사용됩니다. 만다린 오일은 소화불량을 도와 소화를 촉진하고, 딸국질, 근심과 노인들의 간기능의 활성을 도와드립니다 비누나 화장품, 남성용 코롱에도 널리 사용되며 식향으로도 널리 쓰입니다.",
                "마조람 에센셜 오일은 60 센티가량 자라며 털이 있는 줄기와 진녹색의 타원형의 잎과 작은 흰빛을 띄는 꽃을 가진무성한다년생의 나무에서 추출되며 전체적으로 강한 향을 가지고 있습니다. 따듯하고 편안하게 해주는 마조람 에센셜오일은 월경시 복부에 마사지에 사용되기도 하며 피곤하고 통증이 있는 근육을 이완시켜주며 스포츠 마사지에 적합합니다. 몇방울을 가습기에 떨어트려 숙면을 위해 사용하기도 하며 감기 기운이 있을 때 따듯한물에 몇방울 떨어트려 바스를 하기도 합니다.",
                "관목수 분류되는 미르는 약 10 미터 가량까지 자라며 나무줄기에는 적갈색의 눈물이라 불리우는 자연의 올레오레진이 스며나옵니다. 벌목자들은 수확을 증대시키기 위해 나무를 한번 컷팅합니다. 미르는 심신을 강화시켜줍니다. 아로마테라피스트 들은 명상을 위해서나 치료 전에 사용하며 다음과 같은 용도로 사용하실 미르를 사용할 수 있습니다. 살균제, 항균제, 수렴제 치료제, 강장제, 구풍제, 소화제, 카타르치료제, 거담제, 발한제, 상처치료제, 국소마취제, 면역제, 순환촉진제, 항염제, 진경제 등",
                "스윗오렌지는 상록수에서 추출되며 이 나무는 비터오렌지 나무보다 작습니다. 열매는 쓴 막이 없이 달콤한 과육을 가졌습니다. 스윗오렌지 에센셜 오일은 피터오랜지와 그 사용이 비슷합니다. 항우울제, 마취제, 진경제, 최음제, 구풍제, 방취제, 소화촉진제, 강장제등에 효능이 있으며 감기치료, 변비, 고창, 독감, 소화불량, 스트레스등에도 사용되었습니다. ",
                "팔마로사는 야생에서 자라며 호리호리한 긴 줄기와 말단에 꽃이 있습니다. 우거진 잎에서 향기로운 에센셜오일을 추출합니다. 팔마로사는 마취제, 살균제, 소화촉진제, 해열제, 강장제등에 사용되었고 팔마로사의 향은 화장품, 퍼퓸, 비누등에 광범위하게 사용되고 있습니다. 매기티스랑은 그녀의 책 '스트레스: 아로마틱솔루션'에서 팔마로사를 여드름, 탈모증, 집중력저하, 우울증에 사용을 권하고 있습니다.",
                "패출리는 향이 강한 식물로 타원형의 입과 네모진 줄기를 가졌습니다. 2~3 피트 가량 자라며 독특한 향을 제공합니다. 패출리오일은 신경쇠약, 비듬, 염증, 여드름, 피부자극에 도움을 주고 항우울제, 항염증제, 구토억제제, 살균제, 소염제, 마취제, 항독소, 항바이러스, 최음제, 수렴제, 구풍제, 방취제, 소화제, 이뇨제, 해열제, 곰팡이 방지제, 강장제 등에 사용되기도 합니다. 패출리는 년수가 지날수록 효능이 좋아 재배한지 얼마 안된것보다 오래된 제품을 선호합니다. 아로마테라피에선 페출리가 다른 고가의 오일들을 보존하는데 뛰어난 효능이 있다고 알려져있습니다. ",
                "파인은 튼튼한 상록수로 40미터 가량 자라며 영하 40도까지도 견디어 냅니다. 80여종이 넘게 있으며 오렌지옐로 컬러의 꽃과 밤회색의 잎과 솔잎을 가졌습니다. 살균, 소독, 기관지염, 류머티스, 관절염 등에 효과적입니다. 오일은 옅은 노란색을 띈 무색입니다.",
                "40미터가량 자라는 상록수 나무로 나무껍질은 적갈색을 띕니다. 오렌지옐로우 꽃과 갈색은 솔방울을 가졌으며 바늘과 같이 생긴 녹회색의 잎들이 있습니다. 파인스코치 에센셜오일은 진통제, 항균제, 항생제, 살균제, 항바이러스제로 사용됩니다. 아로마테라피스트들은 관절염, 천식, 수포등의 감염, 기관지염, 카타르의 치료를 돕기 위해 사용합니다. 또한 순환계를 도와주고 감기, 기침, 상처, 방광염등, 후두염, 근육통, 신경통, 건선, 류마티스, 백선, 생채기, 정맥동염, 습진에 사용하며, 충혈완화제, 방취제, 살균제, 이뇨제로도 쓰입니다. 파인스코치는 다목적으로 사용되며 이는 문서로도 잘 기록되어있습니다.",
                "1 미터 정도 자라는 다년생 식물로 페퍼민트는 잎은 가장자리가 톱니 모양으로 털이 많으며 꽃은 보라색의 뾰족한 모양입니다. 페퍼민트는 멘톨함량이 많은 걸로 알려졌으며 그 함량이 상당히 높아 가끔 잎이나 추출된 오일에서(끊는 점 약 40도) 크리스탈이 생기기도 합니다. 살균, 탈취 효과, 신경통, 근육통, 소화 촉진, 호흡기 증상 치료, 가려움증에 효과적입니다.",
                "다년생의 식물로 1미터 가량 자라며 페파민트 식물은 가장자리가 톱니모양인 털이 있는 잎과 보라색의 꽃을 가지고 있으며 이 식물로 페퍼민트 알벤시스 오일도 추출합니다. 멘톨성분으로 인한 페퍼민트 효능은  다른 허브초들보다 이 성분이 다량 함유되어 있어서 정신을 맑게해주고 졸음이 올때 잠을 깨워주는 역할도 해주기도 하며, 이러한 각성효과 외에도 허브초 특유의 진정효과 역시 가지고 있어서 긴장을 하거나 화가나서 혈압이 올라가 있을때도 마음을 가라앉혀주는 안정작용도 가져다 주는 그야말로 다방면으로 약효가 뛰어난 허브초중에 하나입니다.",
                "로즈제라늄은 다년생 관목수입니다. 분홍빛이 도는 흰색의 꽃을 가졌고 잎과 줄기에서 수증기증류법으로 오일을 추출합니다. 로즈제라늄오일은 다음과 같은 증상들의 치료를 도와줍니다 : 여드름, 타박상, 화상, 상처, 피부염, 습진, 치질, 머릿이, 버짐, 궤양, 울혈, 부종, 임후염, PMS, 갱년기증상, 스트레스, 신경통 로즈제라늄은 다양한 용도로 사용되는 에센셜 오일이며 그 효능이 문서화로 잘 되어 있습니다.",
                "로즈마리는 신선한 민트향, 나무향을 가지고 있어 피로회복, 정신집중, 기분전환, 자신감 증진등의 도움을 줍니다. 또한 항균/살균 성분을 가지고 있어 감기, 독감, 호흡기질환 예방에 도움을 줍니다. 로즈마리는 아로마테라피에 필수적인 에센셜 오일중 하나입니다.",
                "로즈우드는 작은 상록수로 멸종위기에 처해 브라질 정부로부터 보호 받고 있습니다. 뉴디렉션스는 모든 오일들은 윤리적이고 합법적인 절차로 구매하며 로즈우드 같은 경우에는 브라질 정부가 주관하는 경매에 참가하여 제품의 소스를 얻습니다. 로즈우드는 면역체계에 도움을 주며 살균제, 강장제, 최음제로의 사용이 될 수 있습니다. ",
                "스피아민트는 지중해지역의 토착식물입니다. 내한성이 있는 다년생의 허브로 스피아민트는 약 1미터 가량 자랍니다. 창 모양의 잎과 분홍색이나 라일락 컬러의 꽃을 가지고 있습니다. 아로마테라피스트들은 스피아민트 에센셜오일이 마취제, 진경제, 수렴제, 구풍제 충혈완화제, 소화촉진제, 이뇨제, 거담제등의치료 효능이 있다 이야기 합니다. 스피아민트는 피로와 우울증에 사용하면 활력을 줄 수 있다고 합니다.",
                "탠저린의 원산지는 중국이지만 현재는 주로 미국과 이탈리아의 시칠리에서 자라납니다. 만다린 트리와 매우 비슷하며 탠저린과 만다린은 같은 종입니다. 탠저린 오일은 다른 시트러스과 오일처럼 활력을 주며 향은 마음을 깨끗하게 하고 정서혼란을 없애줍니다. 아로마테라피스트들은 평안, 진정, 따듯하게 하는데 사용하며 퍼퓸, 비누, 진경제, 구풍제, 소화촉진제, 이뇨제, 진정제, 흥분제에 사용되기도 합니다.",
                "티트리나무는 작거나 바늘 같은 잎을 가진 관목수입니다. TI-tree라고도 불리기도 하며 7미터가량까지 자라며 습지에서 잘 자라납니다. 현재는 농장에서 재배됩니다. 티트리는 잘자라서 벌목후 2년뒤면 다시 벌목할 수 있습니다. 티트리 오일은 강력한 면역제로 알려져 있으며 박테리아, 균, 바이러스 같은 모든 전염병의 유기체를 억제하는 것을 도와줍니다. 머린, 피부의 여드름 치료에 좋으며 지성피부, 머릿이 등에 효과가 있습니다. 티트리오일은 점점 대중화 되어 상업용품에도 티트리 오일이 많이 포함되 있습니다.",
                "타임은 다년생 식물로 300여종이 넘으며 30 센티까지 자라납니다. 음식 조리시 많이 사용되기 때문에 일반적으로 '가든타임'이라고 알려져 있으며 녹회색의 타원형의 잎과 관상조직으로 된 담자주색의 꽃을 가지고 있습니다. -타임의 꽃은 하얀색, 분홍색, 보라색 혹은 빨간색의 다양햔 컬러를 가질 수 있습니다. 강한 살균 효과가있어 감기나 독감 등의 감염 예방에 효과적입니다. 두피의 비듬과 탈모 방지에 효과적인 것으로 알려져 있습니다",
                "베티버 에센셜오일은 인도와 스리랑카에서 매트를 만들기 위해 사용되는 풀들의 복합 화이트루트시스템에서 추출되었습니다. 베티버는 뿌리에서 추출하는 에센셜오일의 특징인 흙냄새, 나무 향을 가졌으며 깊은 휴식과 안정을 도와주며 베이스노트는 향수와 아로마테라피에 사용됩니다.",
                "일랑이랑 오일은 꽃중의 꽃이라 알려져 있는 Cananga odorata로부터 추출 되었습니다. 일랑일랑은 20미터정도의 크고 단단한 열대 나무이며 그 꽃은 향기로운 핑크나 자주빛 혹은 노란 빛깔입니다. 노란색꽃이 최상급으로 여겨집니다. 일랑일랑은 달콤하고 이국적이며 플로랄향으로는 가장 많이 수요되고 있는 아로마중 하나로 일랑일랑 오일은 고혈압과, 가쁜 숨과 맥박, 신경과민과 무기력, 한랭 같은 문제에도 도움을 줍니다.",
                "일랑이랑 오일은 꽃중의 꽃이라 알려져 있는 Cananga odorata로부터 추출 되었습니다. 일랑일랑은 20미터정도의 크고 단단한 열대 나무이며 그 꽃은 향기로운 핑크나 자주빛 혹은 노란 빛깔입니다. 노란색꽃이 최상급으로 여겨집니다. 일랑일랑은 달콤하고 이국적이며 플로랄향으로는 가장 많이 수요되고 있는 아로마중 하나로 일랑일랑 오일은 고혈압과, 가쁜 숨과 맥박, 신경과민과 무기력, 한랭 같은 문제에도 도움을 줍니다."};

        aroma_color = new String[] {"녹색톤을 띈 황금빛 노란색","녹색빛을 띈 노란색","연한 금빛의 노란색","옐로브라운","라이트골든옐로","옅은 노란색","무색","옅은 노란색을 띈 무색","옅은 연두색","X","옅은 노란색","옅은 노란색", //12
                "옅은 노란색","밝은 노색을 띈 엷은 노란색","밝은 노색을 띈 엷은 노란색","녹색톤의 옅은 노란색","녹색톤의 옅은 노란색","녹색톤의 옅은 노란색","녹색톤의 옅은 노란색","밝은 노란색","X","연두색","노란색","오렌지", //12
                "깨끗한 밝은 노란색","진한갈색","오렌지","옅은 노란색","진한 황금빛 갈색","X","옅은 노란색을 띈 무색","X","X", "옅은 연두색","X","옅은 노란색을 띈 무색","약간의 녹색빛이 가미된 옅은 노란색","노란색~ 오렌지색", //13
                "옅은 노란색~ 무색","X","진한 갈색","옅은 노란색~ 황금색","옅은 노란색~ 황금색"};

        aroma_blending_oil = new String[] {"버가못, 클라리세이지, 클로브버드, 라임, 유칼립투스, 주니퍼, 레몬, 네롤리, 로즈마리",
                "블랙패퍼, 클라리세이지, 사이프러스, 프랑킨센스, 제라늄, 자스민, 만다린, 넛맥, 오랜지, 로즈마리, 샌달우드, 베티버, 일랑일랑",
                "시트러스계 오일은 시더우드의 베이스노트를 더 좋게 보안해기 때문에 시트러스계 오일들과 블렌딩 하면 좋습니다. 로즈마리, 카모마일, 유칼립투스외 다른 많은 오일들과도 블렌드하여 사용하십시요.",
                "시트로넬라센리온은 대부분의 오일과 블렌드하여 사용하기 좋지만 특히 버가못, 비터오렌지, 시더우드, 제라늄, 레몬, 오렌지, 라벤더, 파인과의 블렌드가 잘 어울어집니다.",
                "클라리세이지는 보통 어떤 오일과도 잘 어울리지만 특히 버가못, 시더우드, 케모마일로먼, 케모마일저먼, 제라늄, 자스민, 라벤더, 네롤리, 오렌지, 로즈우드, 샌달우드, 일랑일랑과 블렌딩하시면 효능이 더 좋습니다.",
                "사이프러스 프렌치는 버가못, 클라리세이지, 펜넬, 그레이프푸룻, 주니퍼, 라벤터, 레몬, 라임, 오렌지, 파인, 로즈마리와 탠저린과 블렌딩이 잘 어울립니다.",
                "파인, 타임, 라벤터, 로즈마리, 마조람, 시더우드, 레몬",
                "X",
                "바질, 버가못, 카다몸, 시더우드, 카모마일, 시나몬, 클라리세이지, 코리앤다, 제라늄, 진저",
                "안젤리카, 바질, 버기못, 캐롯씨드, 시더우드, 시트로넬라, 클라리세이지, 그레이프푸룻, 자스만, 라벤더, 라임, 네놀리, 올렌지, 로즈마리",
                "버가못, 샌달우드, 일랑일랑, 스파이스 오일",
                "그레이프푸룻화이트는 다른 시트러스계 오일들과 잘 어울리며 로즈마리 사이프러스, 라벤더, 제라늄, 카다몸과 대부분의 스파이스 오일하고 잘 어울립니다.",
                "클라리세이지, 샌달우드, 버가못, 제라늄, 마조람, 로즈마리, 카모마일, 유칼립투스 주니퍼베리는 프레쉬하고 리치한 말사믹향과 우디-스윗하고 솔잎향과 같은 상록수의 오일을 생각나게 하는 향을 가졌습니다.",
                "시트러스와 플로랄계의 대부분의 오일과 클로브, 시더우드, 클라리새이지, 파인, 제라늄, 베티버, 패출리",
                "시트러스와 플로랄계의 대부분의 오일과 클로브, 시더우드, 클라리새이지, 파인, 제라늄, 베티버, 패출리",
                "베이, 버가못, 케모마일, 시트로넬라, 클라리새이지, 제라늄, 자스민, 레몬, 만다린, 오렌지, 팔마로사, 패출리, 파인, 탠저린, 타임, 로즈마리, 로즈우드, 일랑일랑",
                "베이, 버가못, 케모마일, 시트로넬라, 클라리새이지, 제라늄, 자스민, 레몬, 만다린, 오렌지, 팔마로사, 패출리, 파인, 탠저린, 타임, 로즈마리, 로즈우드, 일랑일랑",
                "베이, 버가못, 케모마일, 시트로넬라, 클라리새이지, 제라늄, 자스민, 레몬, 만다린, 오렌지, 팔마로사, 패출리, 파인, 탠저린, 타임, 로즈마리, 로즈우드, 일랑일랑",
                "베이, 버가못, 케모마일, 시트로넬라, 클라리새이지, 제라늄, 자스민, 레몬, 만다린, 오렌지, 팔마로사, 패출리, 파인, 탠저린, 타임, 로즈마리, 로즈우드, 일랑일랑",
                "X",
                "X",
                "버가못, 시더우드, 제라늄버번, 그레이프푸룻핑크, 그레이프푸룻화이트, 라벤더(모든타입), 레몬, 만다린, 네롤리, 넛맥, 오렌지스윗, 팔마로사, 페티그레인, 로즈엡솔루트, 로즈마리, 로즈우드, 탠저린, 베티버, 일랑일랑.",
                "바질, 버가못, 제라늄(모든타입), 진저, 자스민(모든타입), 로즈(모든타입), 로즈마리(모든타입), 로즈우드, 일랑일랑",
                "레몬, 오렌지, 라임, 그레이프푸룻과 같은 다른 시트러스계 오일과 잘 어울리며 넛맥, 시나몬, 배이, 글로브와 같은 스파이스 오일과 블렌딩하기 적합합니다.",
                "오렌지, 라벤더, 로즈우드, 프랑켄센스, 티트리, 유칼립투스, 클라리세이지, 바질, 타임, 사이프러스, 엘레미, 카모마일, 넛멕, 시나몬과 같은 스파이스 오일류와 그밖의 다른 많은 오일들과 잘 어울립니다. ",
                "프란킨센스, 라벤더, 팔마로사, 페출ㄹ, 로즈(모든타입), 로즈우드, 샌달우드(모든타입), 티트리, 타임(모든타입)",
                "라벤더, 버가못, 로즈우드, 레몬, 클라리세이지, 미르, 샌달우드, 넛맥, 시나몬, 클로브오일등의 스파이시 오일",
                "카난가, 제라늄, 로즈우드, 샌달우드, 구아이악우드, 시더우드, 플로랄오일",
                "샌달우드, 버가못, 시더우드, 로즈, 스윗오렌지, 케시아, 미르, 오포파낙스, 클라리세이지",
                "X",
                "시트로넬라, 클라리세이지, 코리앤더, 사이프러스, 유칼립투스, 프랑킨센스, 주니퍼, 라벤더, 비르, 로즈마리, 스파이크나드, 티드리",
                "X",
                "X",
                "안젤리카, 바질, 버가못, 캐롯씨드, 시더우드, 시토로넬라, 클라리세이지, 그레이프푸룻, 자스민, 라벤더, 라임, 네롤리, 오렌지, 로즈마리",
                "X",
                "시더우드, 프랑킨센스, 제라늄, 로즈마리, 만다린, 일랑일랑",
                "스피아 민트는 대부분의 에센셜오일과의 블렌딩으로 좋지만 바질, 버치, 버가못, 유칼립투스, 자스민, 라벤더, 로즈마리등과 블렌딩하면 더 좋습니다.",
                "바질, 버가못, 시나몬, 클라리세이지, 클로브, 프랑킨센스, 라벤더, 레몬, 라임, 네놀리, 넛맥, 오렌지",
                "시나몬, 클라리세이지, 클로브, 제라늄, 라벤더, 레몬, 미르, 넛멕, 로즈우드, 로즈마리, 타임",
                "X",
                "시더우드, 카모마일, 프랑킨센스, 진저, 자스민, 주니퍼, 라벤더, 레몬그라스, 패출리, 로즈, 샌달우드, 스파이크나드, 바닐라, 일랑일랑",
                "버가못, 그레이프푸룻, 라벤더, 네롤리, 로즈우드, 샌달우드",
                "버가못, 그레이프푸룻, 라벤더, 네롤리, 로즈우드, 샌달우드"};

        aroma_history = new String[] {"그리스어로 왕실체료제 또는 왕이라는 뜻의 바질은 인도, 아시아, 지중해 나라들에서 식용허브 자주 쓰입니다.",
                "버가못이라는 이름은 이 오일이 처음 매매됬던 장소인 롬바르디아의 베르가모라는 도시에서부터 유래되었습니다. 버가못 나무는 동남아시아 지역이 원산지였지만 유럽의 이탈리아에서 소개되어 아이보리코스트, 모로코, 튀니지와 알제리에서도 찾아볼 수 있습니다.",
                "시더우드의 원산지는 북아프리카에 있는 아틀라스 산입니다. 과거에는 리넨 수납장을 시더우드 나무로 만들었고 오늘날에는 옷좀나방을 피하기 위해 옷걸이를 종종 이 나무로 사용합니다. 고대이집트인들은 일찍이 이 오일을 미라를 만드는데 화장품과 향료로 사용하였습니다.",
                "시트로넬라 셀리온 에센셜오일은 DDT가 시판되기 전에 세계에서 가장 많이 사용되는 방충제였습니다. 최근에는 건강을 많이 생각하는 소비자들이 시트로넬라를 다시 사용하고 있습니다.",
                "클라리세이지는 깨끗하다는 뜻의 라틴어에서 유래되었습니다. - 눈 세정을 위해 사용되었기 때문에 이런 의미가 붙여진 것 같습니다. 16세기에는 영국에서 홉 대신 맥주 양조시 쓰였습니다.",
                "페니키아와 크레타 사람들은 사이프러스 나무를 배와 집을 짓는데 사용했습니다. 이집트인들은 관을 만드는데 사용하였고 그리스인들은 그들의 신들의 조각상을 세우는데 사용하였습니다. 학명 Cupressus sempervirens의 'Sempervirens'는 라틴어로 영원한 삶이라는 뜻을 가졌습니다.",
                "유칼립투스 오일은 호주의 가정에서 오랫동안 사용되왔습니다. 스페인에서는 유칼립투스 나무가 건축재로 사용되었습니다.",
                "펜넬은 예부터 장수와 정신력, 강함을 돕는다고 믿어져 왔습니다. 로마인들은 소화를 촉진한다고 하였고 그리스인들은 체중감량에 좋다고 믿었습니다.",
                "프랑킨센스는 무성하다 혹은 리얼 인센스(real incense)라는 의미를 갖는 프랑스어인 'Franc'에서 기원되었습니다. Olibanum(유향)이라고도 알려진 프랑킨센스는 고대 이집트때부터 사용되어졌습니다.",
                "유렵에 소개된 이후로 제라늄은 나쁜 기운을 쫓기위해 사용었습니다.",
                "인도, 중국, 자바, 아프라카와 서인도제도가 원산지인 진저는 10세기에서 15세기 사이에 조미료와 향료로 유럽에 들어왔다고 합니다. 옛부터 진저는 의료용으로도 사용되왔으며 산스크리트와 중국의 문서에 그 효능이 기록되 있으며 그리스, 로마, 아라비아에서도 문서 기록이 있습니다.",
                "그레이프푸룻화이트와 핑크의 차이점은 미미합니다. 가격은 간단하게 수요와 공급에 따라 차이가 납니다.",
                "인도의 전통 약재로 이 오일은 류마티스의 통증에 사용하며 탈모방지, 상처 지혈제 등으로도 사용합니다.",
                "라벤더는 옛부터 퍼퓸과 의료 목적으로 많이 사용되왔습니다. 로마인들은 라벤더를 목욕물에 사용하여 'to wash'라는 의미의 이탈리아어인 'lavare'에서 그 이름이 유래되었습니다.",
                "라벤더는 옛부터 퍼퓸과 의료 목적으로 많이 사용되왔습니다. 로마인들은 라벤더를 목욕물에 사용하여 'to wash'라는 의미의 이탈리아어인 'lavare'에서 그 이름이 유래되었습니다.",
                "라벤더는 건조한 기후에서 살아가기 접합하고 지중해 서부의 반이 원산지이며 고도 180 미터에까지 자라납니다. 로마와 베네틱토회의 수도사들에 의해 알려졌다고 합니다.",
                "라벤더는 건조한 기후에서 살아가기 접합하고 지중해 서부의 반이 원산지이며 고도 180 미터에까지 자라납니다. 로마와 베네틱토회의 수도사들에 의해 알려졌다고 합니다.",
                "X",
                "X",
                "레몬은 중세시대 유럽에서 알려졌으며 그리스인과 로마인들은 치료효과가 있다고 여겼습니다. 레몬에센셜오일은 영국인들이 괴혈병의 증상을 약화시키는데 시트러스 열매가 사용되기 시작하면서 유명해졌습니다.",
                "X",
                "라임은 바다에서 해군들의 괴혈병을 예방하기 위해 오래전부터 사용해왔습니다.",
                "매이챙 에센셜오일은 일본과 대만에서 사용돼왔습니다.",
                "중국의 남부지방과 극동지방이 원산지로 유럽에는 1805년에 들어왔으며 40년후에 미국에 들여왔습니다.",
                "마조람에센셜오일은 고대 그리스인들이게 매우 인가가 있고 의학재로도 사용되었습니다. '산의 즐거움 이라는 그리스어에서 이름이 기원되었습니다. ",
                "미르는 이집트에서 수세기 동안 향료, 퍼퓸으로 또는 미라를 만들거나 훈증할 때 사용되었습니다. 전통적으로 근육통과 류머티스에 사용되었으며 중국에서는 '모야오'라고 불리우고 B.C 600년때부터 상처에 사용되었습니다. 미르오일은 수지를 증류법을 사용하여 추출하며 상처치료를 위해 고대 그리스때부터 사용되었습니다.",
                "여러가지 설이 있지만 스윗 오렌지는 1세기때 비터오렌지와 함께 아랍인들에의해 유럽에 들어왔다고 믿어지고 있습니다.",
                "팔마로사는 인도의 제라늄 오일로 알려져 있으며 로즈오일과 조합하여 사용됩니다.",
                "유럽에서 유명해지기 전에는 인도숄과 인도잉크는 패출리 특유의 향으로 식별됬습니다.",
                "X",
                "괴혈병 예방을 위해 미국원주민에 의해 사용되었으며 이, 벼룩을 쫓기위해 매트리스 재료로 사용됬습니다. 고대이집트 인들은 파인커넬을 요리 재료로 사용했습니다.",
                "X",
                "X",
                "남부아프리카, 마다가스카르, 이집트, 모로코가 원산지이며 17세기때 이탈리아, 스페인, 프랑스와 같은 유럽의 나라에 소개되었습니다. 제라늄은 옛날에는 나쁜기운을 쫓기위해 집 주변에 심었습니다.",
                "X",
                "로즈우드는 최근에서야 아로마테라피에 소개됬습니다. 1995년 10월에 발표된 연구에서 박테리아의 성장양성과 음성 실험에서 모든 오일 중 가장 높은 억제제를 가지고 있다고 나타났습니다. ",
                "고대 그리스인들은 스피아민트를 목욕물의 향을 위해 사용했습니다. 또한 임질 같은 성병을 치료하는 것으로도 잘 알려졌으며 치아미백과 잇몸통증에도 사용됬습니다. 국소마취의 효과도 있습니다.",
                "탠저린은 중국을 거쳐 유럽에 들여온후 미국에 소개되었습니다. ",
                "호주의 원주민들은 티트리 오일을 오래전부터사용하였으며 또한 티트리 오일은 아로마테라피 영역에서 오랜 역사를 가지고 있습니다. 세계2차대전때 티트리 생산자와 벌목자들은 군대에 충분한 에센션 오일이 축적될때까지 입대가 면제되었습니다. 열대의 전염병과 상처부위의 감염을 치로하기 위해 각 병사들과 해군들은 키트에 티트리 오일을 소지하였습니다.",
                "X",
                "인도와 스리랑케어서 베티버에센셜오일은 고요한 오일이라 알려져 있습니다. 이는 휴식과 안적을 위해 일반적으로 사용되고 있는 베티버 오일에 적절한 비유입니다.",
                "인도네사아에서 일랑일랑 꽃잎은 신혼부부의 침대에 깔아 놓습니다. 일랑일랑은 유럽에서 마카사르 오일로 알려져 있는 헤어 스타일링 성분으로 유명합니다. 안티마카사르(항마카사르) 이것에서 기원되었고 안티마카사르는 가구에 헤어오일의 얼룩이 생기지 않도록 하는데 사용되었습니다.",
                "인도네사아에서 일랑일랑 꽃잎은 신혼부부의 침대에 깔아 놓습니다. 일랑일랑은 유럽에서 마카사르 오일로 알려져 있는 헤어 스타일링 성분으로 유명합니다. 안티마카사르(항마카사르) 이것에서 기원되었고 안티마카사르는 가구에 헤어오일의 얼룩이 생기지 않도록 하는데 사용되었습니다."};

        aroma_caution = new String[] {"민감성 피부에 자극을 줄 수도 있습니다. 임신중 사용은 피하십시요.",
                "버가못오일은 버갑틴 성분이 많이 포함되 있어 민감성 피부에 사용한후 햇볕에 노출되면 화상을 입을 수 있습니다.",
                "독성이나 자극은 없지만 임신중에는 피하십시요.",
                "시트로넬라는 민감성 피부에 자극을 줄 수도 있습니다.",
                "클라리세이지는 독성이 없으며 민감화되지는 않지만 임신중에는 피하세요.",
                "임신(특히 임신 초기)부나 고혈압인 사람은 사용을 피하세요.",
                "유칼립투스는 희석해서 사용하셔야하며 임신중에는 피하십시요.",
                "피부에 자극을 줄수도 있으니 사용하시기 전에 희석을 잘 하셔서 사용하시고 임신중이나 태양 아래에서의 사용은 피하여 주십시요.",
                "프랑킨센스 오일은 독성이 없고 자극이 없어 대부분의 사람들에게 사용가능 합니다.",
                "강한 자극이 있어, 임신 중에 피해야합니다.",
                "진저는 민감한 피부에 자극을 줄수도 있습니다. 사용후 햇볕에 노출을 삼가하십시요.",
                "공표된 부작용은 없으나 아주 드물계 약간의 감광성의 원인이 될 수도 있습니다.",
                "무독성, 무자극의 오일이지만 임신중에는 피해주십시요.",
                "임신중에는 피하세요.",
                "임신중에는 피하세요.",
                "무독성, 무자극성 오일입니다.",
                "무독성, 무자극성 오일입니다.",
                "무독성, 무자극성 오일입니다.",
                "무독성, 무자극성 오일입니다.",
                "무독성이지만 드물게 피부자극이 있을 수도 있습니다. 햇볓에 직접 노출을 피하십시요.",
                "민감한 피부에 사용시는 주의하셔야 합니다.",
                "라임오일은 감광성이 있어 사용후 햇볓의 직접적인 노출은 삼가사여 주십시요.",
                "남용시 피부에 자극을 줄 수도 있습니다.",
                "만다린 에센셜오일 사용후에는 햇볕의 직접적인 노출을 피하십시요.",
                "임신중엔 사용을 피하시고 아이들이 닿지 않게 주의하십시요.",
                "임신중에는 사용을 피하세요.",
                "아로마테라피스트들은 소수의 사람들에게 스윗오렌지의 리모넨성분이 피부염을 일으켰다는 리포트가 있었습니다.",
                "알려지지 않음",
                "알려진바 없음",
                "아주 민감한 피부를 가진 사람에게 자극이 될 수 있습니다. 피부에 사용하는 경우에는 농도를 희석하여 주의하면서 사용하세요.",
                "파인과 파인니들오일은 무독성, 무자극의 안전한 오일이지만 피부에 사용하실때에는 많은량은 피부자극의 원인이 될수 있으니 주의를 요합니다.",
                "자극이 강하기 때문에 원액을 피부에 절대 사용 하지 마십시오. 흡입시에는 눈이 따가울 수 있으므로 눈을 감도록 합니다.",
                "차나 식품첨가제로 적정량 이용할 경우에는 크게 상관이 없지만 오일이나 피부에 직접적으로 접촉되는 제품을 이용할 경우에는 다른 허브초들보다 향과 자극이 강하기에 다소 주의를 하여야 합니다. 특히 임신중이거나 아기에게 수유를 하고 있을 경우에는 가급적 사용을 피합니다.",
                "무독성의 무자극의 오일이지만 임신중엔 피하세요.",
                "임산부, 뇌전증, 고혈압이 있을경우 사용하지 마세요. 정맥혈관위나 아래를 직접 마사지 하지 마세요.",
                "임신중에는 피하세요. 민감한 피부에는 자극을 줄 수도 있습니다.",
                "점막에 자극을 줄 수도 있으나 일반적으로 스피아민트는 부작용이 없습니다.",
                "탠저린은 오일을 피부에 사용한 후에 직사광선을 피하십시요. 피부에 사용하기 전에 잘 희석해서 사용하셔야 합니다.",
                "티트리 에센셜오일은 어떤 사람들에게는 피부의 민감화를 불러올 수 있습니다.",
                "티트리 에센셜오일은 어떤 사람들에게는 피부의 민감화를 불러올 수 있습니다.",
                "알려진 바 없음",
                "일랑일랑을 남용하면 어떤분들에게는 두통과 구토로 이어질 수 있습니다.",
                "일랑일랑을 남용하면 어떤분들에게는 두통과 구토로 이어질 수 있습니다."};
                /*population = new String[] { "1,354,040,000", "1,210,193,422",
                "315,761,000", "237,641,326", "193,946,886", "182,912,000",
                "170,901,000", "152,518,015", "143,369,806", "127,360,000" };*/

        // Locate the ListView in listview_main.xml
        list = (ListView) findViewById(R.id.aroma_listview);

        for (int i = 0; i < aroma_name.length; i++)
        {
            WorldPopulation wp = new WorldPopulation(icon[i], aroma_name[i], aroma_sub_name[i], aroma_extract_part[i], aroma_extract_method[i], aroma_country_origin[i], aroma_detailed_instructions[i],
                    aroma_color[i], aroma_blending_oil[i], aroma_history[i], aroma_caution[i]);
            //population[i]);
            // Binds all strings into an array
            arraylist.add(wp);
        }

        // Pass results to ListViewAdapter Class
        adapter = new ListViewAdapter(this, arraylist);

        // Binds the Adapter to the ListView
        list.setAdapter(adapter);
        editsearch = (EditText) findViewById(R.id.search);

        final ImageButton main_btn = (ImageButton)findViewById(R.id.move_to_main);
        final ImageButton search_btn = (ImageButton)findViewById(R.id.move_to_search);
        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main_btn.setVisibility(View.INVISIBLE);
                search_btn.setVisibility(View.INVISIBLE);
                editsearch.setVisibility(View.VISIBLE);
                editsearch.requestFocus();
                editsearch.setImeOptions(EditorInfo.IME_ACTION_SEARCH);
                editsearch.setTextColor(Color.BLACK);
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
            }
        });

        //메인화면에서 검색 버튼 눌러서 들어온 경우에 검색  기능 활성화
        Intent intent = getIntent();
        Boolean search_enable = intent.getBooleanExtra("search_enable",false);
        if(search_enable){
            main_btn.setVisibility(View.INVISIBLE);
            search_btn.setVisibility(View.INVISIBLE);
            editsearch.setVisibility(View.VISIBLE);
            editsearch.requestFocus();
            editsearch.setImeOptions(EditorInfo.IME_ACTION_SEARCH);
            editsearch.setTextColor(Color.BLACK);
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
        }


        // Locate the EditText in listview_main.xml

        // Capture Text in EditText
        editsearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
                String text = editsearch.getText().toString().toLowerCase(Locale.getDefault());
                adapter.filter(text);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1,
                                          int arg2, int arg3) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2,
                                      int arg3) {
                // TODO Auto-generated method stub
            }
        });

        editsearch.setOnEditorActionListener(new TextView.OnEditorActionListener(){
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_SEARCH) {
                    editsearch.setVisibility(View.INVISIBLE);
                    main_btn.setVisibility(View.VISIBLE);
                    search_btn.setVisibility(View.VISIBLE);
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
                    return true;
                }
                return false;
            }
        });

        editsearch.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(editsearch.getWindowToken(), 0);
                    return true;
                }
                return false;
            }
        });


        LinearLayout therapy_dictionary_color = (LinearLayout)findViewById(R.id.therapy_dictionary_color1);
        therapy_dictionary_color.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TherapyDictionaryColorActivity.class);
                startActivity(intent);
            }
        });

        //하단 바 클릭 이벤트 처리
        LinearLayout link_color_therapy = (LinearLayout)findViewById(R.id.link_color_therapy);
        link_color_therapy.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ColorTherapyActivity.class);
                startActivity(intent);
            }
        });
        LinearLayout link_aroma_therapy = (LinearLayout)findViewById(R.id.link_aroma_therapy);
        link_aroma_therapy.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AromaTherapyActivity.class);
                startActivity(intent);
            }
        });
        LinearLayout link_dictionary = (LinearLayout)findViewById(R.id.link_dictionary);
        link_dictionary.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), TherapyDictionaryActivity.class);
//                startActivity(intent);
            }
        });
        LinearLayout link_settings = (LinearLayout)findViewById(R.id.link_settings);
        link_settings.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "준비중입니다.", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
