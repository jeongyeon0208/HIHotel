[API 명세서](https://www.notion.so/bfb1c9d1064544329c79de55d4533cc7?pvs=21)


회원가입	POST	/user/signup	{
  cid : String,
  name : String,
  phone : String
}	
로그인	POST	/user/signin	{
  cid : String
}

//관리자 로그인 아이디는 admin	
호텔예약	POST	/user/booking	{
  cid : String,
  hid : String
  roomNumber : String
  checkin : Date
  checkout : Date
}	
호텔예약 취소	DELETE	/user/booking/cancel	{
  bookingId : Long
}	
전체 예약정보 조회	GET	/user/bookings		[
  {
    cid : String,
    hid : String
    roomNumber : String,
    checkin : Date,
    checkout : Date
  }
]
회원탈퇴	DELETE	/user/delete	{
  customerId : Long
}	
투숙정보 조회	GET	/user/stayinformations		[
  {
    cid : String,
    hid : String
    roomNumber : String,
    checkin : Date,
    checkout : Date
  }
]
관리자 호텔 삽입	POST	/admin/hotel		
관리자 호텔방 삽입	POST	/admin/hotelroom		
관리자 투숙정보 삽입	POST	/admin/stayinformation		
관리자 호텔 삭제	DELETE	/admin/hotel/delete		
관리자 호텔방 삭제	DELETE	/admin/hotelroom/delete		
관리자 예약 조회	GET	/admin/bookings		[
  {
    cid : String,
    cname : String,
    hid : String,
    hname : String
    roomNumber : String,
    price : int
    checkin : Date
    checkout : Date
  }
]