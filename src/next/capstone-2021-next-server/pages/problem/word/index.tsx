import React from 'react';
import { NextRouter, useRouter } from "next/router";
import { useSelector } from 'react-redux';
import { RootState } from "../../../src/modules";
import { LowLevelWord, TopLevelWord } from "../../../src/container/problem";
import Histories from "../../../src/container/problem/Histories";

const WordProblem = () => {
    const { level, problems } = useSelector((state: RootState) => state.ProbReducer);

    const router: NextRouter = useRouter();
    React.useEffect(() => {
        if (level === undefined || problems.length === 0) router.back();
    }, [ ])

    return (
        <div style={{ width: '100%', height: '100%', display: 'flex', flexDirection: 'row' }}>
            {
                level === 2 ?
                    <TopLevelWord />
                    :
                    <LowLevelWord />
            }
            <div style={{ height: '100vh', display: 'flex', alignItems: 'center', marginRight: '2rem' }}>
                <Histories />
            </div>
        </div>
    )
}

export default WordProblem;