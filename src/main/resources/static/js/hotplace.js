// 공공데이터 서비스 키
const serviceKey =
  "MsJ8m3KE1BZRPPU4a%2B4glQobhuo6032W3s7fL90AnUrHal0TqMrveuvQyEEs%2FP9VexVGAo%2BvJSn%2B1RtSF2DBFQ%3D%3D";


  // 공공데이터 여행지 호출
async function fetchHotplace() {
    let areaCode = 4;
    let contentTypeId = 12;
    let gugunCode = 4;
  
    let searchUrl = `https://apis.data.go.kr/B551011/KorService1/areaBasedList1?serviceKey=${serviceKey}&contentTypeId=${contentTypeId}&areaCode=${areaCode}&sigunguCode=${gugunCode}&MobileOS=ETC&MobileApp=TestApp&_type=json&numOfRows=20`;
  
    const response = await fetch(searchUrl);
    const data = await response.json();
    const hotplace = document.getElementById("hotplace");
    let hotplaceList = "";
    console.log(data.response.body.items.item);
    for (item of data.response.body.items.item) {
        hotplaceList += `<div class="hot"><div>${item.title}</div><div><img src="${item.firstimage}"/></div></div></div></div>`;
    }

    hotplace.innerHTML = hotplaceList;

}

fetchHotplace();