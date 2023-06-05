/** 
import {useState, useEffect} from 'react';

// coin data 정보를 읽어오고 화면에 보이기.
function App() {
    const [loading, setLoding] = useState(true);
    const [hospitals, setHospitals] = useState([]);
    useEffect(() => {
      fetch("https://openapi.gg.go.kr/RecuperationHospital?KEY=e773163cf73d429b81008f1c8b081444&Type=json")
      .then((response)=>response.json())
      .then((json)=>{
        setLoding(false);
        setHospitals(json.RecuperationHospital[1].row);
      });
    },[])

  return (
    <div className="App">
      <h1>요양병원 정보</h1>
      {
        loading ? <strong>Loding...</strong> : null
      }
      <ul>
        {
          hospitals.map((hospital) => {
            return (
              <>
                <li>지역 : {hospital.SIGUN_NM}</li>
                <li>병원 이름 : {hospital.BIZPLC_NM}</li>
                <li>진료 과목 : {hospital.TREAT_SBJECT_CONT}</li>
                <br/>
              </>
            )
          })
        }
      </ul>
    </div>
  );

}

export default App;*/

import React, {useEffect, useState} from 'react';
import axios from 'axios';

function App() {
    // 리스트 객체
    const [silverList, setList] = useState([{
        id: '',
        name: '',
        location: '',
        category: ''
    }]);
    // 백엔드단에서 리스트 객체를 가져오는 부분
    useEffect(() => {
        axios.get("/main/test")
            .then(res => setList(res.data.silverList))
            .catch(error => console.log(error))

    }, []);
    return (
        <div>
            <div className="silverList">
                <table className="silverTable">
                    <thead>
                    <tr>
                        <th className="col-lg-2">
                           이름 
                        </th>
                        <th className="col-lg-8">
                            위치 
                        </th>
                        <th className="col-lg-2">
                            카테고리 
                        </th>
                    </tr>
                    </thead>
                    <tbody>
                    {/* list.map을 사용해서 반복문 구현 */}
                    {silverList.map((silver, id) => {
                        return (
                            <tr key={silver.id}>
                                <td>{silver.name}</td>
                                <td>{silver.location}</td>
                                <td>{silver.category}</td>
                            </tr>
                        )
                    })}

                    </tbody>
                </table>
            </div>
        </div>
    );
}
export default  App;