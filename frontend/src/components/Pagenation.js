// import styled from "styled-components";
// import {useState} from 'react';

// function PageNation({total, limit, page, setPage}) {
//   const [currPage, setCurrPage] = useState(page);
//   let firstNum = currPage - (currPage % 5) + 1;
//   let lastNum = currPage - (currPage % 5) + 5;

//     // 필요한 page의 수를 설정
//     const numPages = Math.ceil(total/limit);

//     return (
//         <Nav>
//             <Button onClick={() => {setPage(page-1); setCurrPage(page-2);}} disabled={page === 1}>
//                 &lt;
//             </Button>
//             <Button 
//                     onClick={() => setPage(firstNum)}
//                     aria-current={page === firstNum ? "page" : null}>
//                     {firstNum}
//                 </Button>
//                 {Array(4).fill().map((_, i) =>{
//                   if(i+1>=numPages) return null;
//                   else {
//                     if(i <=2){
//                       return (
//                           <Button
//                               border="true" 
//                               key={i+1} 
//                               onClick={() => {setPage(firstNum+1+i)}}
//                               aria-current={page === firstNum+1+i ? "page" : null}>
//                               {firstNum+1+i}
//                           </Button>
//                       )
//                   }
//                   else if(i>=3){
//                       return (
//                           <Button
//                               border="true" 
//                               key ={i+1}
//                               onClick={() => setPage(lastNum)}
//                               aria-current={page === lastNum ? "page" : null}>
//                               {lastNum}
//                           </Button>
//                       )  
//                   }
//                   }
                    
//                 })}
//             <Button onClick={() => {setPage(page + 1);setCurrPage(page); }} disabled={page === numPages}>
//                 &gt;
//             </Button>
//         </Nav>
//     )

// }

// const Nav = styled.nav`
//   display: flex;
//   justify-content: center;
//   align-items: center;
//   gap: 4px;
//   margin: 16px;
// `;

// const Button = styled.button`
//   border: none;
//   border-radius: 8px;
//   padding: 8px;
//   margin: 0;
//   background: grey;
//   color: white;
//   font-size: 1rem;

//   &:hover {
//     background: tomato;
//     cursor: pointer;
//     transform: translateY(-2px);
//   }

//   &[disabled] {
//     background: grey;
//     cursor: revert;
//     transform: revert;
//   }

//   &[aria-current] {
//     background: black;
//     font-weight: bold;
//     cursor: revert;
//     transform: revert;
//   }
// `;

// export default PageNation;