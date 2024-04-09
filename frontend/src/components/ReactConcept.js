import React from 'react';

function ReactConcept({ title, description, image }) {
    return (
        <div className="react-concept">
            <h2>{title}</h2>
            <p>{description}</p>
            <img src={image} alt={title} style={{maxWidth: '100%', height: 'auto'}}/>
        </div>
    );
}

export default ReactConcept;