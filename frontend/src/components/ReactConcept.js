import React from 'react';

function ReactConcept({ title, description }) {
    return (
        <div className="react-concept">
            <h2>{title}</h2>
            <p>{description}</p>
        </div>
    );
}

export default ReactConcept;