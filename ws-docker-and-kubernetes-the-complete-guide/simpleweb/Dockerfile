# Specify a base image
FROM node:14-alpine

# Setting work directory on temporary container
WORKDIR /usr/app

# Copy the package.json from this root directory to the work directory of the temporary container
COPY ./package.json ./

# Install some dependencies
RUN npm install

# Copy all files from this root directory to root directory of work directory of the temporary container
COPY ./ ./

# Default command
CMD [ "npm", "start" ]
