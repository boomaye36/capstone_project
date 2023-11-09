
import { useEffect, useState} from "react";
import axios from "axios";

import RouterWeb from "./RouterWeb.js";
import { silverDataAtom } from "../../recoil/silverDataAtom.js";
import { useRecoilState, useSetRecoilState } from "recoil";

function App() {
  const [relateData, setRelateData] = useState([]);
  const [testSilverData, setTestSilverData] = useState([]);
  const setSilverData = useSetRecoilState(silverDataAtom);
  
  useEffect(() => {
      axios.get("http://ec2-3-34-136-247.ap-northeast-2.compute.amazonaws.com:8080/")
      .then(res => {
        setSilverData(res.data.silverList)
        setTestSilverData(res.data.silverList)
        setRelateData(res.data.relateSilverData)
      })
      .catch(error => console.log(error))
   }, []);
 
  useEffect(() => {
      axios.get("http://ec2-3-34-136-247.ap-northeast-2.compute.amazonaws.com:8080/relate1?original_hospital=경기도노인전문남양주병원")
      .then(res => {
       	console.log(res)
      })
      .catch(error => console.log(error))
   }, []);

  return (
    <div className="App">
      {
        console.log(relateData)
      }
      {
        console.log(testSilverData)
      }
      <RouterWeb/>
    </div>
  );
}

export default App;

