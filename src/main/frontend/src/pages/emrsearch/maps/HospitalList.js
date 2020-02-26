import React from 'react';
import HosipitalItem from './HospitalItem';

const HospitalList = ({data}) => {

    return (
        <div>
            {data.map(data=>(
                <HosipitalItem key={data.hpid} data={data}   />
            ))}
           
        </div>
    );
};

export default HospitalList;