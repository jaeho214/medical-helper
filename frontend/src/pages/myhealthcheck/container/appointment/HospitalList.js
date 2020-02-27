import React from 'react';
import HospitalItem from './HospitalItem';
import HospitalForm from './HospitalForm';
import Grid from "@material-ui/core/Grid";



class HospitalList extends React.Component{

    render(){
        const {data}=this.props;
        return (
            <>
        
            <div>
                {data.map(data=>(
                    <div>
                    <Grid       
                     container 
                     direction="row" 
                    >
                        <Grid sm={8}><HospitalItem key={data.id} data={data} /></Grid>
                        <Grid sm={4}><HospitalForm hospitalName={data.name} hospitalId={data.id} /></Grid>
                    </Grid>
                    </div>
                ))}

            </div>
            </>
        );
    }
}


export default HospitalList;